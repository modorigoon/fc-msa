package me.modorigoon.pay.remittance.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository


interface SpringDataRemittanceRequestRepository: JpaRepository<RemittanceRequestJpaEntity, Long>
