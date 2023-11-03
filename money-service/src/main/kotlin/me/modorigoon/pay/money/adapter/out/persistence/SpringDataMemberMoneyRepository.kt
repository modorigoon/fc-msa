package me.modorigoon.pay.money.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository


interface SpringDataMemberMoneyRepository : JpaRepository<MemberMoneyJpaEntity, Long> {

    fun findTopByMembershipIdOrderByMemberMoneyIdDesc(membershipId: Long): MemberMoneyJpaEntity?
}
