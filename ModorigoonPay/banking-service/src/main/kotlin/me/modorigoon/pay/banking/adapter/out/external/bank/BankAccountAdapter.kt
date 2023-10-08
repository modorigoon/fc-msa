package me.modorigoon.pay.banking.adapter.out.external.bank

import me.modorigoon.pay.banking.application.port.out.RequestBankAccountInfoPort
import me.modorigoon.pay.banking.application.port.out.RequestExternalFirmBankingPort
import me.modorigoon.pay.common.ExternalSystemAdapter


@ExternalSystemAdapter
class BankAccountAdapter : RequestBankAccountInfoPort, RequestExternalFirmBankingPort {

    override fun getBankAccountInfo(bankName: String, bankAccountNumber: String): BankAccount? {
        return BankAccount(bankName, bankAccountNumber, true)
    }

    override fun requestExternalFirmBanking(request: ExternalFirmBankingRequest): FirmBankingResult =
        FirmBankingResult(0)
}
