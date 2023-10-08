package me.modorigoon.pay.banking.adapter.out.persistence

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "firm_banking_request")
data class FirmBankingRequestJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val firmBankingRequestId: Long?,

    val fromBankName: String,
    val fromBankAccountNumber: String,

    val toBankName: String,
    val toBankAccountNumber: String,

    val moneyAmount: Int,

    val firmBankingStatus: Int,

    val uuid: String
)
