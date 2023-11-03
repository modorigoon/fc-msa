package me.modorigoon.pay.money.application.port.out


fun interface GetMembershipPort {

    fun getMembership(membershipId: Long): Membership?
}
