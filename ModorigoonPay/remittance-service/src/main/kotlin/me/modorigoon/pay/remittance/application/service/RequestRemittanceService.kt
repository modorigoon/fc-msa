package me.modorigoon.pay.remittance.application.service

import me.modorigoon.pay.common.UseCase
import me.modorigoon.pay.remittance.application.port.`in`.RequestRemittanceCommand
import me.modorigoon.pay.remittance.application.port.`in`.RequestRemittanceUseCase
import me.modorigoon.pay.remittance.application.port.out.RequestRemittancePort
import me.modorigoon.pay.remittance.application.port.out.banking.BankingPort
import me.modorigoon.pay.remittance.application.port.out.membership.MembershipPort
import me.modorigoon.pay.remittance.application.port.out.money.MoneyPort
import me.modorigoon.pay.remittance.domain.RemittanceRequest
import javax.transaction.Transactional
import kotlin.math.ceil


@UseCase
@Transactional
class RequestRemittanceService(
    val requestRemittancePort: RequestRemittancePort,
    val membershipPort: MembershipPort,
    val moneyPort: MoneyPort,
    val bankingPort: BankingPort
) : RequestRemittanceUseCase {

    override fun requestRemittance(command: RequestRemittanceCommand): RemittanceRequest? {

        val remittanceRequest = requestRemittancePort.saveRemittanceRequestHistory(
            RemittanceRequest(
                remittanceRequestId = null,
                remittanceFromMembershipId = command.fromMembershipId,
                remittanceToMembershipId = command.toMembershipId,
                toBankName = command.toBankName,
                toBankAccountNumber = command.toBankAccountNumber,
                remittanceType = command.remittanceType,
                amount = command.amount,
                remittanceStatus = "READY"
            )
        )

        val membershipStatus = membershipPort.getMembershipStatus(command.fromMembershipId)
        if (membershipStatus == null || !membershipStatus.isValid) {
            return null
        }

        val moneyInfo = moneyPort.getMoneyInfo(command.fromMembershipId)!!
        if (moneyInfo.balance < command.amount) {
            val rechargeAmount = (ceil((command.amount - moneyInfo.balance) / 10000.0) * 10000).toInt()
            val moneyResult = moneyPort.requestMoneyRecharging(command.fromMembershipId, rechargeAmount)
            if (!moneyResult) {
                return null
            }
        }

        if (command.remittanceType == 0) {
            val remittanceResult1 = moneyPort.requestMoneyDecrease(command.fromMembershipId, command.amount)
            val remittanceResult2 = moneyPort.requestMoneyIncrease(command.toMembershipId, command.amount)
            if (!remittanceResult1 || !remittanceResult2) {
                return null
            }
        } else if (command.remittanceType == 1) {
            val remittanceResult = bankingPort
                .requestFirmBanking(command.toBankName, command.toBankAccountNumber, command.amount)
            if (!remittanceResult) {
                return null
            }
        }

        remittanceRequest.remittanceStatus = "SUCCESS"

        return requestRemittancePort.saveRemittanceRequestHistory(remittanceRequest)
    }
}
