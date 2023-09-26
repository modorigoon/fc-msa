package me.modorigoon.pay.membership.adapter.`in`.web

import me.modorigoon.pay.common.WebAdapter
import me.modorigoon.pay.membership.application.port.`in`.ModifyMembershipCommand
import me.modorigoon.pay.membership.application.port.`in`.ModifyMembershipUseCase
import me.modorigoon.pay.membership.domain.Membership
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@WebAdapter
@RestController
class ModifyMembershipController(val modifyMembershipUseCase: ModifyMembershipUseCase) {

    @PutMapping("/membership/modify")
    fun modifyMembershipById(@RequestBody request: ModifyMembershipRequest): ResponseEntity<Membership> {
        println("request modify: $request")
        val command = ModifyMembershipCommand(
            membershipId = request.membershipId,
            address = request.address,
            email = request.email,
            name = request.name,
            isValid = true,
            isCorp = request.corp
        )
        val membership = modifyMembershipUseCase.modifyMembership(command)
        return ResponseEntity.ok(membership)
    }
}
