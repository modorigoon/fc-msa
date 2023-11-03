package me.modorigoon.pay.membership

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@EnableWebMvc
@SpringBootApplication
class MembershipApplication

fun main(args: Array<String>) {
    runApplication<MembershipApplication>(*args)
}
