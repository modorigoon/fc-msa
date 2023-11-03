package me.modorigoon.pay.taskconsumer

import kotlinx.serialization.json.Json
import me.modorigoon.pay.common.RechargingMoneyTask
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service


@Service
class TaskConsumer(val taskResultProducer: TaskResultProducer) {

    @KafkaListener(topics = ["modorigoonpay.task"], groupId = "mygroup")
    fun consume(
        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) messageKey: String,
        @Payload message: String
    ) {
        val task: RechargingMoneyTask = Json.decodeFromString<RechargingMoneyTask>(message)
        task.subTaskList.map { it.status = "SUCCESS" }

        taskResultProducer.sendTaskResult(messageKey, task)
    }
}
