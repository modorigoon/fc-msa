package me.modorigoon.pay.money.adapter.`in`.kafka

import kotlinx.serialization.json.Json
import me.modorigoon.pay.common.CountDownLatchManager
import me.modorigoon.pay.common.LoggingProducer
import me.modorigoon.pay.common.RechargingMoneyTask
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component


@Component
class RechargingMoneyResultConsumer(
    val countDownLatchManager: CountDownLatchManager,
    val loggingProducer: LoggingProducer
) {

    @KafkaListener(topics = ["modorigoonpay.task.result"], groupId = "mygroup")
    fun rechargingMoneyResultConsume(
        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) messageKey: String,
        @Payload message: String
    ) {
        val task: RechargingMoneyTask = Json.decodeFromString(message)
        val taskSuccessful = task.subTaskList.find { it.status == "FAILED" } == null
        val resultCode = if (taskSuccessful) {
            "SUCCESS"
        } else {
            "FAILED"
        }
        loggingProducer.sendMessage(task.taskId, "TASK_$resultCode")
        countDownLatchManager.setDataForKey(task.taskId, resultCode)
        countDownLatchManager.getCountDownLatch(task.taskId).countDown()
    }
}
