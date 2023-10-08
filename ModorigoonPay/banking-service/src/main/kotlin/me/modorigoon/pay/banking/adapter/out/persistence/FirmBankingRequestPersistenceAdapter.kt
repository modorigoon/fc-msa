package me.modorigoon.pay.banking.adapter.out.persistence

import me.modorigoon.pay.banking.application.port.out.FirmBankingRequestPort
import me.modorigoon.pay.banking.domain.FirmBankingRequest
import me.modorigoon.pay.common.PersistenceAdapter
import java.util.UUID


@PersistenceAdapter
class FirmBankingRequestPersistenceAdapter(
    val springDataFirmBankingRequestRepository: SpringDataFirmBankingRequestRepository,
    val firmBankingRequestMapper: FirmBankingRequestMapper
) : FirmBankingRequestPort {

    override fun createFirmBankingRequest(
        fromBankName: String, fromBankAccountNumber: String,
        toBankName: String, toBankAccountNumber: String,
        moneyAmount: Int
    ): FirmBankingRequest = firmBankingRequestMapper.mapToDomainEntity(
        springDataFirmBankingRequestRepository.save(
            FirmBankingRequestJpaEntity(
                firmBankingRequestId = null,
                fromBankName = fromBankName,
                fromBankAccountNumber = fromBankAccountNumber,
                toBankName = toBankName,
                toBankAccountNumber = toBankAccountNumber,
                moneyAmount = moneyAmount,
                firmBankingStatus = 0,
                uuid = UUID.randomUUID().toString()
            )
        )
    )

    override fun saveFirmBankingRequest(firmBankingRequest: FirmBankingRequest): FirmBankingRequest =
        firmBankingRequestMapper.mapToDomainEntity(
            springDataFirmBankingRequestRepository.save(
                FirmBankingRequestJpaEntity(
                    firmBankingRequestId = firmBankingRequest.firmBankingRequestId,
                    fromBankName = firmBankingRequest.fromBankName,
                    fromBankAccountNumber = firmBankingRequest.fromBankAccountNumber,
                    toBankName = firmBankingRequest.toBankName,
                    toBankAccountNumber = firmBankingRequest.toBankAccountNumber,
                    moneyAmount = firmBankingRequest.moneyAmount,
                    firmBankingStatus = firmBankingRequest.firmBankingStatus,
                    uuid = firmBankingRequest.uuid
                )
            )
        )
}
