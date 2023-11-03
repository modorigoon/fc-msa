package me.modorigoon.pay.banking.adapter.out.persistence

import me.modorigoon.pay.banking.domain.RegisteredBankAccount
import org.springframework.stereotype.Component


@Component
class RegisteredBankAccountMapper {

    fun mapToDomainEntity(entity: RegisteredBankAccountJpaEntity): RegisteredBankAccount =
        RegisteredBankAccount(
            registeredBankAccountId = entity.registeredBankAccountId,
            membershipId = entity.membershipId,
            bankName = entity.bankName,
            bankAccountNumber = entity.bankAccountNumber,
            linkedStatusIsValid = entity.linkedStatusIsValid
        )
}
