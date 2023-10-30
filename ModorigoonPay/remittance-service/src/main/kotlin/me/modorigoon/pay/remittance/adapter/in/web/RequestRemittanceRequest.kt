package me.modorigoon.pay.remittance.adapter.`in`.web


data class RequestRemittanceRequest(
    val fromMembershipId: Long,
    val toMembershipId: Long,
    val toBankName: String,
    val toBankAccountNumber: String,
    val remittanceType: Int,
    val amount: Int
)
