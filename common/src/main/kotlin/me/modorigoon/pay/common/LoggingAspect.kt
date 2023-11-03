package me.modorigoon.pay.common

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component


@Profile("!test")
@Aspect
@Component
class LoggingAspect(val loggingProducer: LoggingProducer) {

    @Before("execution(* me.modorigoon.pay.*.adapter.in.web.*.*(..)))")
    fun beforeMethodExecution(joinPoint: JoinPoint) {
        val methodName = joinPoint.signature.name
        loggingProducer.sendMessage("logging", "Before executing method: $methodName")
    }
}
