package me.modorigoon.pay.banking.application.port.out

import me.modorigoon.pay.banking.domain.FirmBankingRequest


interface FirmBankingRequestPort {

    fun createFirmBankingRequest(
        fromBankName: String, fromBankAccountNumber: String,
        toBankName: String, toBankAccountNumber: String,
        moneyAmount: Int
    ): FirmBankingRequest

    fun saveFirmBankingRequest(firmBankingRequest: FirmBankingRequest): FirmBankingRequest
}
