package me.modorigoon.pay.remittance.application.port.out

import me.modorigoon.pay.remittance.application.port.`in`.FindRemittanceCommand
import me.modorigoon.pay.remittance.domain.RemittanceRequest


fun interface FindRemittancePort {

    fun findRemittanceHistory(command: FindRemittanceCommand): List<RemittanceRequest>
}
