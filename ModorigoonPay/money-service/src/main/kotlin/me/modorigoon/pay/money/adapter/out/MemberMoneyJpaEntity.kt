package me.modorigoon.pay.money.adapter.out

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "member_money")
data class MemberMoneyJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberMoneyId: Long?,
    val membershipId: Long,
    val balance: Int
) {
    fun addBalance(amount: Int): MemberMoneyJpaEntity =
        this.copy(balance = balance + amount)
}
