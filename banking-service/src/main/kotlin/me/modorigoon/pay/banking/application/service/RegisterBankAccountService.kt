package me.modorigoon.pay.banking.application.service

import me.modorigoon.pay.banking.application.port.`in`.RegisterBankAccountCommand
import me.modorigoon.pay.banking.application.port.`in`.RegisterBankAccountUseCase
import me.modorigoon.pay.banking.application.port.out.GetMembershipPort
import me.modorigoon.pay.banking.application.port.out.RegisterBankAccountPort
import me.modorigoon.pay.banking.application.port.out.RequestBankAccountInfoPort
import me.modorigoon.pay.banking.domain.RegisteredBankAccount
import me.modorigoon.pay.common.UseCase
import javax.transaction.Transactional


@UseCase
@Transactional
class RegisterBankAccountService(
    val registerBankAccountPort: RegisterBankAccountPort,
    val requestBankAccountInfoPort: RequestBankAccountInfoPort,
    val getMembershipPort: GetMembershipPort
) : RegisterBankAccountUseCase {

    override fun registerBankAccount(command: RegisterBankAccountCommand): RegisteredBankAccount {

        val membership = getMembershipPort.getMembership(membershipId = command.membershipId)
            ?: throw NullPointerException("Bank member not found.")

        val bankAccount = requestBankAccountInfoPort.getBankAccountInfo(command.bankName, command.bankAccountNumber)
            ?: throw NullPointerException("Bank account can not be a null")
        bankAccount.checkIsValid()

        return registerBankAccountPort.createRegisteredBankAccount(
            membershipId = membership.membershipId,
            bankName = command.bankName,
            bankAccountNumber = command.bankAccountNumber,
            linkedStatusIsValid = command.linkedStatusIsValid
        )
    }
}
