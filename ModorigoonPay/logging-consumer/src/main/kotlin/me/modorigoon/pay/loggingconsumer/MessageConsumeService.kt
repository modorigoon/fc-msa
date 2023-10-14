package me.modorigoon.pay.loggingconsumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service


@Service
class MessageConsumeService {

    @KafkaListener(topics = ["modorigoonpay.logging.out.stdout"], groupId = "my-group")
    fun consumeMyopic2(@Payload message: String?, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) partition: Int) {
        println("message [partition: $partition]: $message")
    }
}
