package me.modorigoon.pay.remittance.application.port.`in`

import me.modorigoon.pay.remittance.domain.RemittanceRequest


fun interface FindRemittanceUseCase {

    fun findRemittanceHistory(command: FindRemittanceCommand): List<RemittanceRequest>
}
