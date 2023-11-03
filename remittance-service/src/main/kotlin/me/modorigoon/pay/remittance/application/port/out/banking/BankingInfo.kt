package me.modorigoon.pay.remittance.application.port.out.banking


data class BankingInfo(
    val bankName: String,
    val bankAccountNumber: String,
    val isValid: Boolean
)
