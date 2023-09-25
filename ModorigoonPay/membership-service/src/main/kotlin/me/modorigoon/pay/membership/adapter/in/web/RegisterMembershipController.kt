package me.modorigoon.pay.membership.adapter.`in`.web

import me.modorigoon.pay.membership.application.port.`in`.RegisterMembershipCommand
import me.modorigoon.pay.membership.application.port.`in`.RegisterMembershipUseCase
import me.modorigoon.pay.membership.common.WebAdapter
import me.modorigoon.pay.membership.domain.Membership
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@WebAdapter
@RestController
class RegisterMembershipController(
    val registerMembershipUseCase: RegisterMembershipUseCase
) {

    @PostMapping("/membership/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody request: RegisterMemberShipRequest): Membership {
        val command = RegisterMembershipCommand(
            name = request.name,
            email = request.email,
            address = request.address,
            isValid = true,
            isCorp = request.corp
        )
        return registerMembershipUseCase.registerMembership(command)
    }
}
