package me.modorigoon.pay.banking.adapter.out.service

import kotlinx.serialization.json.Json
import me.modorigoon.pay.banking.application.port.out.GetMembershipPort
import me.modorigoon.pay.banking.application.port.out.Membership
import me.modorigoon.pay.common.CommonHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class MembershipServiceAdapter(
    val commonHttpClient: CommonHttpClient,
    @Value("\${service.membership.url}") val membershipServiceUrl: String
) : GetMembershipPort {

    override fun getMembership(membershipId: Long): Membership? {
        return runCatching {
            val url = "${membershipServiceUrl}/membership/${membershipId}"
            val response = commonHttpClient.sendGetRequest(url)
            Json.decodeFromString<Membership>(response.body())
        }.getOrNull()
    }
}
