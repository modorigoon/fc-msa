package me.modorigoon.pay.membership.adapter.out.persistance

import org.springframework.data.jpa.repository.JpaRepository


interface SpringDataMembershipRepository : JpaRepository<MembershipJpaEntity, Long>
