package me.modorigoon.pay.money.adapter.out.persistence

import me.modorigoon.pay.common.PersistenceAdapter
import me.modorigoon.pay.money.application.port.out.IncreaseMoneyPort
import me.modorigoon.pay.money.domain.MemberMoney
import me.modorigoon.pay.money.domain.MoneyChangingRequest
import java.sql.Timestamp


@PersistenceAdapter
class MoneyChangingRequestPersistenceAdapter(
    val springDataMoneyChangingRequestRepository: SpringDataMoneyChangingRequestRepository,
    val springDataMemberMoneyRepository: SpringDataMemberMoneyRepository,
    val moneyChangingRequestMapper: MoneyChangingRequestMapper,
    val memberMoneyMapper: MemberMoneyMapper
) : IncreaseMoneyPort {

    override fun createMoneyChangingRequest(
        targetMembershipId: Long, moneyChangingType: Int, changingMoneyAmount: Int,
        moneyChangingStatus: Int, uuid: String
    ): MoneyChangingRequest =
        moneyChangingRequestMapper.mapToDomainEntity(
            springDataMoneyChangingRequestRepository.save(
                MoneyChangingRequestJpaEntity(
                    moneyChangingRequestId = null,
                    targetMembershipId = targetMembershipId,
                    moneyChangingType = moneyChangingType,
                    moneyAmount = changingMoneyAmount,
                    timestamp = Timestamp(System.currentTimeMillis()),
                    changingMoneyStatus = moneyChangingStatus,
                    uuid = uuid
                )
            )
        )

    override fun increaseMoney(memberId: Long, increaseMoneyAmount: Int): MemberMoney {
        val memberMoney = springDataMemberMoneyRepository
            .findTopByMembershipIdOrderByMemberMoneyIdDesc(memberId) ?: MemberMoneyJpaEntity(
            memberMoneyId = null,
            membershipId = memberId,
            balance = 0
        )

        return memberMoneyMapper.mapToDomainEntity(
            springDataMemberMoneyRepository.save(memberMoney.addBalance(increaseMoneyAmount))
        )
    }
}
