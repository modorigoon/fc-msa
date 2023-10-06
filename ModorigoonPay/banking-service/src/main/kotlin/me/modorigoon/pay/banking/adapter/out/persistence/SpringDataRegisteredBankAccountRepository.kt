package me.modorigoon.pay.banking.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository


interface SpringDataRegisteredBankAccountRepository : JpaRepository<RegisteredBankAccountJpaEntity, Long>
