package me.modorigoon.pay.remittance.adapter.out.persistence

import me.modorigoon.pay.remittance.domain.RemittanceRequest
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "request_remittance")
data class RemittanceRequestJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val remittanceRequestId: Long,
    val fromMembershipId: Long,
    val toMembershipId: Long,
    val toBankName: String,
    val toBankAccountNumber: String,
    val remittanceType: Int,
    val amount: Int,
    val remittanceStatus: String
) {
    constructor(remittanceRequest: RemittanceRequest) : this(
        remittanceRequestId = remittanceRequest.remittanceRequestId,
        fromMembershipId = remittanceRequest.remittanceFromMembershipId,
        toMembershipId = remittanceRequest.remittanceToMembershipId,
        toBankName = remittanceRequest.toBankName,
        toBankAccountNumber = remittanceRequest.toBankAccountNumber,
        remittanceType = remittanceRequest.remittanceType,
        amount = remittanceRequest.amount,
        remittanceStatus = remittanceRequest.remittanceStatus
    )

    fun toRemittanceRequest(): RemittanceRequest = RemittanceRequest(
        remittanceRequestId = remittanceRequestId,
        remittanceFromMembershipId = fromMembershipId,
        remittanceToMembershipId = toMembershipId,
        toBankName = toBankName,
        toBankAccountNumber = toBankAccountNumber,
        remittanceType = remittanceType,
        amount = amount,
        remittanceStatus = remittanceStatus
    )
}
