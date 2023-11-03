package me.modorigoon.pay.loggingconsumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class MessageConsumeService {

    @KafkaListener(topics = ["modorigoonpay.logging.out.stdout"], groupId = "mygroup")
    fun consume(message: String?) {
        println("message: $message")
    }
}
