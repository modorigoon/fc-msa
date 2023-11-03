package me.modorigoon.pay.money.adapter.out.persistence

import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType


@Entity
@Table(name = "money_changing_request")
data class MoneyChangingRequestJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val moneyChangingRequestId: Long?,
    val targetMembershipId: Long,
    val moneyChangingType: Int,
    val moneyAmount: Int,

    @Temporal(TemporalType.TIMESTAMP)
    val timestamp: Date,

    val changingMoneyStatus: Int,
    val uuid: String
)
