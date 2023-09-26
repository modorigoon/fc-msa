package me.modorigoon.pay.membership.application.service

import me.modorigoon.pay.common.UseCase
import me.modorigoon.pay.membership.application.port.`in`.FindMembershipCommand
import me.modorigoon.pay.membership.application.port.`in`.FindMembershipUseCase
import me.modorigoon.pay.membership.application.port.out.FindMembershipPort
import me.modorigoon.pay.membership.domain.Membership


@UseCase
class FindMembershipService(val findMembershipPort: FindMembershipPort) : FindMembershipUseCase {

    override fun findMembership(command: FindMembershipCommand): Membership =
        findMembershipPort.findMembershipById(command.membershipId)
}
