package me.modorigoon.pay.common

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.stereotype.Component
import java.util.Properties


@Component
class LoggingProducer {

    private final var producer: KafkaProducer<String, String>
    val topic = "modorigoonpay.logging.out.stdout"

    init {
        val props = Properties()
        props["bootstrap.servers"] = "kafka:29092"
        props["key.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
        props["value.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
        producer = KafkaProducer(props)
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
