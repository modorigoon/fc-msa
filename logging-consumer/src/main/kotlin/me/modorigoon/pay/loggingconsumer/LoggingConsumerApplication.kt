package me.modorigoon.pay.loggingconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka


@EnableKafka
@SpringBootApplication
class LoggingConsumerApplication

fun main(args: Array<String>) {
    runApplication<LoggingConsumerApplication>(*args)
}
