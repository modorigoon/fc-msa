package me.modorigoon.pay.banking.adapter.out.persistence

import me.modorigoon.pay.banking.domain.FirmBankingRequest
import org.springframework.stereotype.Component


@Component
class FirmBankingRequestMapper {

    fun mapToDomainEntity(entity: FirmBankingRequestJpaEntity): FirmBankingRequest =
        FirmBankingRequest(
            firmBankingRequestId = entity.firmBankingRequestId,
            fromBankName = entity.fromBankName,
            fromBankAccountNumber = entity.fromBankAccountNumber,
            toBankName = entity.toBankName,
            toBankAccountNumber = entity.toBankAccountNumber,
            moneyAmount = entity.moneyAmount,
            firmBankingStatus = entity.firmBankingStatus,
            uuid = entity.uuid
        )
}
