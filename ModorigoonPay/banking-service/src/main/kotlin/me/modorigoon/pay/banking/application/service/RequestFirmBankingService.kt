package me.modorigoon.pay.banking.application.service

import me.modorigoon.pay.banking.adapter.out.external.bank.ExternalFirmBankingRequest
import me.modorigoon.pay.banking.application.port.`in`.RequestFirmBankingCommand
import me.modorigoon.pay.banking.application.port.`in`.RequestFirmBankingUseCase
import me.modorigoon.pay.banking.application.port.out.FirmBankingRequestPort
import me.modorigoon.pay.banking.application.port.out.RequestExternalFirmBankingPort
import me.modorigoon.pay.banking.domain.FirmBankingRequest
import me.modorigoon.pay.common.UseCase


@UseCase
class RequestFirmBankingService(
    val firmBankingRequestPort: FirmBankingRequestPort,
    val requestExternalFirmBankingPort: RequestExternalFirmBankingPort
) : RequestFirmBankingUseCase {

    override fun requestFirmBanking(command: RequestFirmBankingCommand): FirmBankingRequest {

        val firmBankingRequest = firmBankingRequestPort.createFirmBankingRequest(
            command.fromBankName,
            command.fromBankAccountNumber,
            command.toBankName,
            command.toBankAccountNumber,
            command.moneyAmount
        )

        val externalRequest = ExternalFirmBankingRequest(
            fromBankName = command.fromBankName,
            fromBankAccountNumber = command.fromBankAccountNumber,
            toBankName = command.toBankName,
            toBankAccountNumber = command.toBankAccountNumber,
            moneyAmount = command.moneyAmount
        )
        val firmBankingResult = requestExternalFirmBankingPort.requestExternalFirmBanking(externalRequest)

        val firmBankingRequestResult = if (firmBankingResult.resultCode == 0) {
            firmBankingRequest.toComplete()
        } else {
            firmBankingRequest.toFailed()
        }

        return firmBankingRequestPort.saveFirmBankingRequest(firmBankingRequestResult)
    }
}
