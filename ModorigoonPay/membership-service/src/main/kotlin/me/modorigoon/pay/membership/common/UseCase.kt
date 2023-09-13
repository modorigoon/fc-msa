package me.modorigoon.pay.membership.common

import org.springframework.stereotype.Component


@Target(AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class UseCase(val value: String = "")
