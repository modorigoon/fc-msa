package me.modorigoon.pay.money

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@EnableWebMvc
@SpringBootApplication
class MoneyServiceApplication

fun main(args: Array<String>) {
    runApplication<MoneyServiceApplication>(*args)
}
