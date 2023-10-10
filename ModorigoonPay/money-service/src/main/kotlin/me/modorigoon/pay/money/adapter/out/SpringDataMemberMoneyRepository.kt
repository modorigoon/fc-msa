package me.modorigoon.pay.money.adapter.out

import org.springframework.data.jpa.repository.JpaRepository


interface SpringDataMemberMoneyRepository : JpaRepository<MemberMoneyJpaEntity, Long> {

    fun findTopByMembershipIdOrderByMemberMoneyIdDesc(membershipId: Long): MemberMoneyJpaEntity?
}
