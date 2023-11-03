package me.modorigoon.pay.banking.adapter.out.persistence

import me.modorigoon.pay.banking.application.port.out.RegisterBankAccountPort
import me.modorigoon.pay.banking.domain.RegisteredBankAccount
import me.modorigoon.pay.common.PersistenceAdapter


@PersistenceAdapter
class RegisteredBankAccountPersistenceAdapter(
    val springDataRegisteredBankAccountRepository: SpringDataRegisteredBankAccountRepository,
    val registeredBankAccountMapper: RegisteredBankAccountMapper
) : RegisterBankAccountPort {

    override fun createRegisteredBankAccount(
        membershipId: Long, bankName: String, bankAccountNumber: String, linkedStatusIsValid: Boolean
    ): RegisteredBankAccount = registeredBankAccountMapper.mapToDomainEntity(
        springDataRegisteredBankAccountRepository.save(
            RegisteredBankAccountJpaEntity(
                registeredBankAccountId = null,
                membershipId = membershipId,
                bankName = bankName,
                bankAccountNumber = bankAccountNumber,
                linkedStatusIsValid = linkedStatusIsValid
            )
        )
    )
}
