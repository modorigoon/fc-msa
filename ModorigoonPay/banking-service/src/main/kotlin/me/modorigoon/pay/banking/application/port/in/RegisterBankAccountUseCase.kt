package me.modorigoon.pay.banking.application.port.`in`

import me.modorigoon.pay.banking.domain.RegisteredBankAccount


fun interface RegisterBankAccountUseCase {

    fun registerBankAccount(command: RegisterBankAccountCommand): RegisteredBankAccount
}
