package me.modorigoon.pay.membership

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.web.filter.CharacterEncodingFilter


@Target(AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@AutoConfigureMockMvc
@Import(EnableMockMvc.Config::class)
annotation class EnableMockMvc {
    class Config {
        @Bean
        fun characterEncodingFilter(): CharacterEncodingFilter {
            return CharacterEncodingFilter("UTF-8", true)
        }
    }
}
