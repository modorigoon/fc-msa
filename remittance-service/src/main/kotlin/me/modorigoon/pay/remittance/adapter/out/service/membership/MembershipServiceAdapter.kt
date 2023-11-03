package me.modorigoon.pay.remittance.adapter.out.service.membership

import kotlinx.serialization.json.Json
import me.modorigoon.pay.common.CommonHttpClient
import me.modorigoon.pay.common.ExternalSystemAdapter
import me.modorigoon.pay.remittance.application.port.out.membership.MembershipPort
import me.modorigoon.pay.remittance.application.port.out.membership.MembershipStatus
import org.springframework.beans.factory.annotation.Value


@ExternalSystemAdapter
class MembershipServiceAdapter(
    val commonHttpClient: CommonHttpClient,
    @Value("\${service.membership.url}") val membershipServiceUrl: String
): MembershipPort {

    override fun getMembershipStatus(membershipId: Long): MembershipStatus? {
        val membership = runCatching {
            val url = "${membershipServiceUrl}/membership/${membershipId}"
            val response = commonHttpClient.sendGetRequest(url)
            Json.decodeFromString<Membership>(response.body())
        }.getOrNull() ?: return null

        return MembershipStatus(membership.membershipId, membership.isValid)
    }
}
