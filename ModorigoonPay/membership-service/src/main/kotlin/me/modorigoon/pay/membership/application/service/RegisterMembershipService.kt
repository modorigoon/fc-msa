package me.modorigoon.pay.membership.application.service

import me.modorigoon.pay.common.UseCase
import me.modorigoon.pay.membership.application.port.`in`.RegisterMembershipCommand
import me.modorigoon.pay.membership.application.port.`in`.RegisterMembershipUseCase
import me.modorigoon.pay.membership.application.port.out.RegisterMembershipPort
import me.modorigoon.pay.membership.domain.Membership
import org.springframework.transaction.annotation.Transactional


@UseCase
@Transactional
class RegisterMembershipService(val registerMembershipPort: RegisterMembershipPort) : RegisterMembershipUseCase {

    override fun registerMembership(command: RegisterMembershipCommand): Membership =
        registerMembershipPort.createMembership(
            command.name, command.email, command.address, command.isValid, command.isCorp
        )
}
