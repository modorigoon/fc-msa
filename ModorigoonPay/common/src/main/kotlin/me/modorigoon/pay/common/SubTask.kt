package me.modorigoon.pay.common

import kotlinx.serialization.Serializable


@Serializable
data class SubTask(
    val membershipId: Long,
    val subTaskName: String,
    val taskType: String,
    var status: String
)
