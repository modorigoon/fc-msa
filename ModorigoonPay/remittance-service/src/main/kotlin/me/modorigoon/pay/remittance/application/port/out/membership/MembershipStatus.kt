package me.modorigoon.pay.remittance.application.port.out.membership


data class MembershipStatus(
    val membershipId: Long,
    val isValid: Boolean
)
