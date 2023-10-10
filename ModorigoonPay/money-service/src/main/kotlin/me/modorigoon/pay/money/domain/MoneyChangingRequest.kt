package me.modorigoon.pay.money.domain

import java.util.Date


data class MoneyChangingRequest(
    val moneyChangingRequestId: Long?,
    val targetMembershipId: Long,
    val changingType: Int,
    val changingMoneyAmount: Int,
    val changingMoneyStatus: Int,
    val uuid: String,
    val createdAt: Date
)
