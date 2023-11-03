package me.modorigoon.pay.membership.application.port.out

import me.modorigoon.pay.membership.domain.Membership


fun interface RegisterMembershipPort {

    fun createMembership(name: String, email: String, address: String, isValid: Boolean, isCorp: Boolean): Membership
}
