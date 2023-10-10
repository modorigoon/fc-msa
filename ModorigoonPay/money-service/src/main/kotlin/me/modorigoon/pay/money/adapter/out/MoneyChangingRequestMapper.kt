package me.modorigoon.pay.money.adapter.out

import me.modorigoon.pay.money.domain.MoneyChangingRequest
import org.springframework.stereotype.Component


@Component
class MoneyChangingRequestMapper {

    fun mapToDomainEntity(entity: MoneyChangingRequestJpaEntity): MoneyChangingRequest =
        MoneyChangingRequest(
            moneyChangingRequestId = entity.moneyChangingRequestId,
            targetMembershipId = entity.targetMembershipId,
            changingType = entity.moneyChangingType,
            changingMoneyAmount = entity.moneyAmount,
            changingMoneyStatus = entity.changingMoneyStatus,
            uuid = entity.uuid,
            createdAt = entity.timestamp
        )
}
