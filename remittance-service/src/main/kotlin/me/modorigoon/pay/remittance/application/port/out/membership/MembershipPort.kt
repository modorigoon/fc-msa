package me.modorigoon.pay.remittance.application.port.out.membership


fun interface MembershipPort {

    fun getMembershipStatus(membershipId: Long): MembershipStatus?
}
