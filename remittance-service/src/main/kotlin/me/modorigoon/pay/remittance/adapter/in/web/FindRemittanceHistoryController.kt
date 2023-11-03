package me.modorigoon.pay.remittance.adapter.`in`.web

import me.modorigoon.pay.common.WebAdapter
import me.modorigoon.pay.remittance.application.port.`in`.FindRemittanceCommand
import me.modorigoon.pay.remittance.application.port.`in`.FindRemittanceUseCase
import me.modorigoon.pay.remittance.domain.RemittanceRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@WebAdapter
@RestController
class FindRemittanceHistoryController(val findRemittanceUseCase: FindRemittanceUseCase) {

    @GetMapping("/remittance/{membershipId}")
    fun findRemittanceHistory(@PathVariable(name = "membershipId") membershipId: Long): List<RemittanceRequest> {
        val command = FindRemittanceCommand(membershipId)
        return findRemittanceUseCase.findRemittanceHistory(command)
    }
}
