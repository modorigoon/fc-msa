package me.modorigoon.pay.banking.application.port.out

import me.modorigoon.pay.banking.adapter.out.external.bank.BankAccount


fun interface RequestBankAccountInfoPort {

    fun getBankAccountInfo(bankName: String, bankAccountNumber: String): BankAccount?
}
