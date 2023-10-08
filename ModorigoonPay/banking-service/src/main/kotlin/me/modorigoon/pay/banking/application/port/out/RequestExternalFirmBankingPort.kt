package me.modorigoon.pay.banking.application.port.out

import me.modorigoon.pay.banking.adapter.out.external.bank.ExternalFirmBankingRequest
import me.modorigoon.pay.banking.adapter.out.external.bank.FirmBankingResult


fun interface RequestExternalFirmBankingPort {

    fun requestExternalFirmBanking(request: ExternalFirmBankingRequest): FirmBankingResult
}
