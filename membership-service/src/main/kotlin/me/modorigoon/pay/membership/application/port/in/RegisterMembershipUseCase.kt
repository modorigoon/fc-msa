package me.modorigoon.pay.membership.application.port.`in`

import me.modorigoon.pay.membership.domain.Membership


fun interface RegisterMembershipUseCase {

    fun registerMembership(command: RegisterMembershipCommand): Membership
}
