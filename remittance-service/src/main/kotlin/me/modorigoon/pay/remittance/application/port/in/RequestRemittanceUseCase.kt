package me.modorigoon.pay.remittance.application.port.`in`

import me.modorigoon.pay.remittance.domain.RemittanceRequest


fun interface RequestRemittanceUseCase {

    fun requestRemittance(command: RequestRemittanceCommand): RemittanceRequest?
}
