package me.modorigoon.pay.remittance.adapter.out.service.membership

import kotlinx.serialization.Serializable


@Serializable
data class Membership(
    val membershipId: Long,
    val name: String,
    val email: String,
    val address: String,
    val isValid: Boolean,
    val isCorp: Boolean
)
