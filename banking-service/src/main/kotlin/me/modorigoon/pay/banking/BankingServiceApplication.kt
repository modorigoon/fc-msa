package me.modorigoon.pay.banking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@EnableWebMvc
@SpringBootApplication
class BankingServiceApplication

fun main(args: Array<String>) {
    runApplication<BankingServiceApplication>(*args)
}
