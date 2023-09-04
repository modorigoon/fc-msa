package me.modorigoon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication


@SpringBootApplication
@ConfigurationPropertiesScan
class TestApplication

fun main(args: Array<String>) {
    runApplication<TestApplication>(*args)
}
