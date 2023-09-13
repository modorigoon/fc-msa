package me.modorigoon.pay.membership.application.port.out

import me.modorigoon.pay.membership.domain.Membership


fun interface FindMembershipPort {

    fun findMembershipById(id: Long): Membership
}
