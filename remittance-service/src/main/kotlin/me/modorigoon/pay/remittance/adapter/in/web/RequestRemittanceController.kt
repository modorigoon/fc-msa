package me.modorigoon.pay.remittance.adapter.`in`.web

import me.modorigoon.pay.common.WebAdapter
import me.modorigoon.pay.remittance.application.port.`in`.RequestRemittanceCommand
import me.modorigoon.pay.remittance.application.port.`in`.RequestRemittanceUseCase
import me.modorigoon.pay.remittance.domain.RemittanceRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@WebAdapter
@RestController
class RequestRemittanceController(val requestRemittanceUseCase: RequestRemittanceUseCase) {

    @PostMapping("/remittance/request")
    fun requestRemittance(@RequestBody request: RequestRemittanceRequest): RemittanceRequest? {

        val command = RequestRemittanceCommand(
            fromMembershipId = request.fromMembershipId,
            toMembershipId = request.toMembershipId,
            toBankName = request.toBankName,
            toBankAccountNumber = request.toBankAccountNumber,
            remittanceType = request.remittanceType,
            amount = request.amount
        )

        return requestRemittanceUseCase.requestRemittance(command)
    }
}
