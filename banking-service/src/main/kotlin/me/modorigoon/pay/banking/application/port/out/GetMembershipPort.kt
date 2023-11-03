package me.modorigoon.pay.banking.application.port.out


fun interface GetMembershipPort {

    fun getMembership(membershipId: Long): Membership?
}
