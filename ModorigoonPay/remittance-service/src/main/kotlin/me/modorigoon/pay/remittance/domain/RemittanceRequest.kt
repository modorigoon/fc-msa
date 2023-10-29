package me.modorigoon.pay.remittance.domain


data class RemittanceRequest(
    val remittanceRequestId: Long?,
    val remittanceFromMembershipId: Long,
    val remittanceToMembershipId: Long,
    val toBankName: String,
    val toBankAccountNumber: String,
    val remittanceType: Int,
    val amount: Int,
    var remittanceStatus: String
)
