package me.modorigoon.pay.membership.adapter.`in`.web

import me.modorigoon.pay.membership.application.port.`in`.FindMembershipCommand
import me.modorigoon.pay.membership.application.port.`in`.FindMembershipUseCase
import me.modorigoon.pay.membership.common.WebAdapter
import me.modorigoon.pay.membership.domain.Membership
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@WebAdapter
@RestController
class FindMembershipController(val findMembershipUseCase: FindMembershipUseCase) {

    @GetMapping("/membership/{membershipId}")
    fun findMembershipById(@PathVariable(name = "membershipId") membershipId: Long): ResponseEntity<Membership> {
        val command = FindMembershipCommand(membershipId)
        val membership = findMembershipUseCase.findMembership(command)
        return ResponseEntity.ok(membership)
    }
}
