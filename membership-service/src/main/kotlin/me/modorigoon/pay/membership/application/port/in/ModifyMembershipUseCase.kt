package me.modorigoon.pay.membership.application.port.`in`

import me.modorigoon.pay.membership.domain.Membership


fun interface ModifyMembershipUseCase {

    fun modifyMembership(command: ModifyMembershipCommand): Membership
}
