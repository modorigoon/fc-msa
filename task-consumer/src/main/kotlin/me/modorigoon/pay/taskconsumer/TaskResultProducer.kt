package me.modorigoon.pay.taskconsumer

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import me.modorigoon.pay.common.RechargingMoneyTask
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.util.Properties


@Profile("!test")
@Component
class TaskResultProducer {

    private final var producer: KafkaProducer<String, String>
    val topic = "modorigoonpay.task.result"

    init {
        val props = Properties()
        props["bootstrap.servers"] = "kafka:29092"
        props["key.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
        props["value.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
        producer = KafkaProducer(props)
    }

    fun sendTaskResult(key: String, taskResult: RechargingMoneyTask) {
        val value = Json.encodeToString(taskResult)
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
