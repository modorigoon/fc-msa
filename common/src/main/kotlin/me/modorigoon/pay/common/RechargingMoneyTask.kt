package me.modorigoon.pay.common

import kotlinx.serialization.Serializable


@Serializable
data class RechargingMoneyTask(
    val taskId: String,
    val taskName: String,
    val membershipId: Long,
    val subTaskList: List<SubTask>,

    val toBankName: String,
    val toBankAccountNumber: String,
    val moneyAmount: Int
)
