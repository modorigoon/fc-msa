package me.modorigoon.pay.money.adapter.out.kafka

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import me.modorigoon.pay.common.RechargingMoneyTask
import me.modorigoon.pay.money.application.port.out.SendRechargingMoneyTaskPort
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.stereotype.Component
import java.util.Properties


@Component
class TaskProducer : SendRechargingMoneyTaskPort {

    private final var producer: KafkaProducer<String, String>
    val topic = "modorigoonpay.task"

    init {
        val props = Properties()
        props["bootstrap.servers"] = "kafka:29092"
        props["key.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
        props["value.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
        producer = KafkaProducer(props)
    }

    override fun sendRechargingMoneyTask(task: RechargingMoneyTask) {
        this.sendMessage(task.taskId, Json.encodeToString(serializer(RechargingMoneyTask::class.java), task))
    }

    fun sendMessage(key: String, value: String) {
        val record = ProducerRecord(topic, key, value)
        producer.send(record) { m, e ->
            if (e == null) {
                println("message sent successfully: " + m.offset())
            } else {
                println("error: " + e.message)
            }
        }
    }
}
