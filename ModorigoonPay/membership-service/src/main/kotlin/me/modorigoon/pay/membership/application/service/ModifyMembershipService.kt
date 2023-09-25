package me.modorigoon.pay.membership.application.service

import me.modorigoon.pay.membership.application.port.`in`.ModifyMembershipCommand
import me.modorigoon.pay.membership.application.port.`in`.ModifyMembershipUseCase
import me.modorigoon.pay.membership.application.port.out.ModifyMembershipPort
import me.modorigoon.pay.membership.common.UseCase
import me.modorigoon.pay.membership.domain.Membership


@UseCase
class ModifyMembershipService(val modifyMembershipPort: ModifyMembershipPort) : ModifyMembershipUseCase {

    override fun modifyMembership(command: ModifyMembershipCommand): Membership {
        println("modify command: $command")

        return modifyMembershipPort.modifyMembership(
            id = command.membershipId,
            name = command.name,
            address = command.address,
            email = command.email,
            isValid = command.isValid,
            isCorp = command.isCorp
        )
    }
}
