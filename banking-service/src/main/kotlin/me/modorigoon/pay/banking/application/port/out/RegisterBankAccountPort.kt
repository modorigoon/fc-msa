package me.modorigoon.pay.banking.application.port.out

import me.modorigoon.pay.banking.domain.RegisteredBankAccount


fun interface RegisterBankAccountPort {

    fun createRegisteredBankAccount(
        membershipId: Long, bankName: String, bankAccountNumber: String, linkedStatusIsValid: Boolean
    ): RegisteredBankAccount
}
