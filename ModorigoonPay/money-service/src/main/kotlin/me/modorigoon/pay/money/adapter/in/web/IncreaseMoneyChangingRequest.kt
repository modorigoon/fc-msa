package me.modorigoon.pay.money.adapter.`in`.web


data class IncreaseMoneyChangingRequest(
    val targetMembershipId: Long,
    val amount: Int
)
