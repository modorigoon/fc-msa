package me.modorigoon.pay.membership.adapter.out.persistance

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "membership")
data class MembershipJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val membershipId: Long?,

    val name: String,
    val address: String,
    val email: String,
    val isValid: Boolean,
    val isCorp: Boolean
)
