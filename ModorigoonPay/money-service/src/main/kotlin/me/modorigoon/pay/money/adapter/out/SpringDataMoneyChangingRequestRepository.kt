package me.modorigoon.pay.money.adapter.out

import org.springframework.data.jpa.repository.JpaRepository


interface SpringDataMoneyChangingRequestRepository : JpaRepository<MoneyChangingRequestJpaEntity, Long>
