package me.modorigoon.pay.banking.application.port.`in`

import me.modorigoon.pay.banking.domain.FirmBankingRequest


fun interface RequestFirmBankingUseCase {

    fun requestFirmBanking(command: RequestFirmBankingCommand): FirmBankingRequest
}
