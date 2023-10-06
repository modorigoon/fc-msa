package me.modorigoon.pay.banking.adapter.out.external.bank

import me.modorigoon.pay.banking.application.port.out.RequestBankAccountInfoPort
import me.modorigoon.pay.common.ExternalSystemAdapter


@ExternalSystemAdapter
class BankAccountAdapter : RequestBankAccountInfoPort {

    override fun getBankAccountInfo(bankName: String, bankAccountNumber: String): BankAccount? {
        return BankAccount(bankName, bankAccountNumber, true)
    }
}
