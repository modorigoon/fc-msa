package me.modorigoon.pay.remittance.adapter.out.persistence

import me.modorigoon.pay.common.PersistenceAdapter
import me.modorigoon.pay.remittance.application.port.`in`.FindRemittanceCommand
import me.modorigoon.pay.remittance.application.port.out.FindRemittancePort
import me.modorigoon.pay.remittance.application.port.out.RequestRemittancePort
import me.modorigoon.pay.remittance.domain.RemittanceRequest


@PersistenceAdapter
class RemittanceRequestPersistenceAdapter(
    val springDataRemittanceRequestRepository: SpringDataRemittanceRequestRepository
) : RequestRemittancePort, FindRemittancePort {

    override fun findRemittanceHistory(command: FindRemittanceCommand): List<RemittanceRequest> {
        return emptyList()
    }

    override fun saveRemittanceRequestHistory(request: RemittanceRequest): RemittanceRequest =
        springDataRemittanceRequestRepository.save(RemittanceRequestJpaEntity(request)).toRemittanceRequest()
}
