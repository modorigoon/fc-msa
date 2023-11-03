package me.modorigoon.pay.remittance.application.service

import me.modorigoon.pay.common.UseCase
import me.modorigoon.pay.remittance.application.port.`in`.FindRemittanceCommand
import me.modorigoon.pay.remittance.application.port.`in`.FindRemittanceUseCase
import me.modorigoon.pay.remittance.application.port.out.FindRemittancePort
import me.modorigoon.pay.remittance.domain.RemittanceRequest
import javax.transaction.Transactional


@UseCase
@Transactional
class FindRemittanceService(
    val findRemittancePort: FindRemittancePort
) : FindRemittanceUseCase {

    override fun findRemittanceHistory(command: FindRemittanceCommand): List<RemittanceRequest> =
        findRemittancePort.findRemittanceHistory(command)
}
