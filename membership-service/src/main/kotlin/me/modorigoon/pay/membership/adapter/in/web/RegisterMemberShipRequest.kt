package me.modorigoon.pay.membership.adapter.`in`.web


data class RegisterMemberShipRequest(
    val name: String,
    val address: String,
    val email: String,
    val corp: Boolean
)
