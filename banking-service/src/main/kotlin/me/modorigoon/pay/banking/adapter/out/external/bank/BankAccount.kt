package me.modorigoon.pay.banking.adapter.out.external.bank


data class BankAccount(
    val bankName: String,
    val bankAccountNumber: String,
    val isValid: Boolean
) {
    fun checkIsValid() {
        check(isValid)
    }
}
