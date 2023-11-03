package me.modorigoon.pay.common

import org.springframework.stereotype.Component


@Target(AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class ExternalSystemAdapter(val value: String = "")
