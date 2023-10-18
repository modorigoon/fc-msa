package me.modorigoon.pay.money.adapter.`in`.web


data class MoneyChangingResultDetail(
    val moneyChangingRequestId: Long,
    val moneyChangingType: Int,
    val moneyChangingStatus: Int,
    val amount: Int
)
