package me.modorigoon.pay.money.adapter.out

import me.modorigoon.pay.money.domain.MemberMoney
import org.springframework.stereotype.Component


@Component
class MemberMoneyMapper {

    fun mapToDomainEntity(entity: MemberMoneyJpaEntity): MemberMoney =
        MemberMoney(
            memberMoneyId = entity.memberMoneyId,
            membershipId = entity.membershipId,
            balance = entity.balance
        )
}
