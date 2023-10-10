package me.modorigoon.pay.money.domain


data class MemberMoney(
    val memberMoneyId: Long?,
    val membershipId: Long,
    val balance: Int
)
