package me.modorigoon.pay.banking.adapter.`in`.web


data class RegisterBankAccountRequest(
    val membershipId: Long,
    val bankName: String,
    val bankAccountNumber: String,
    val linkedStatusIsValid: Boolean
)
