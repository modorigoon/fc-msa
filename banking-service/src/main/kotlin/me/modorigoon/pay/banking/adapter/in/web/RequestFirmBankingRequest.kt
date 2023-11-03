package me.modorigoon.pay.banking.adapter.`in`.web


data class RequestFirmBankingRequest(
    val fromBankName: String,
    val fromBankAccountNumber: String,
    val toBankName: String,
    val toBankAccountNumber: String,
    val moneyAmount: Int
)
