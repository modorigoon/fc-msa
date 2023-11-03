package me.modorigoon.pay.banking.application.port.out

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
