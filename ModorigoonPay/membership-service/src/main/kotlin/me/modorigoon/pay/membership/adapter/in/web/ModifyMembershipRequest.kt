package me.modorigoon.pay.membership.adapter.`in`.web


data class ModifyMembershipRequest(
    val membershipId: Long,
    val name: String,
    val address: String,
    val email: String,
    val corp: Boolean
)
