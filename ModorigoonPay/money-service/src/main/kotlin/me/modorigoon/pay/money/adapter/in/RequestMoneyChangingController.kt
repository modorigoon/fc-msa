package me.modorigoon.pay.money.adapter.`in`

import me.modorigoon.pay.common.WebAdapter
import me.modorigoon.pay.money.application.usecase.IncreaseMoneyRequestCommand
import me.modorigoon.pay.money.application.usecase.IncreaseMoneyRequestUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@WebAdapter
@RestController
class RequestMoneyChangingController(val increaseMoneyRequestUseCase: IncreaseMoneyRequestUseCase) {

    @PostMapping("/money/increase")
    fun increaseMoney(@RequestBody request: IncreaseMoneyChangingRequest): ResponseEntity<MoneyChangingResultDetail> {
        val command = IncreaseMoneyRequestCommand(
            targetMembershipId = request.targetMembershipId, amount = request.amount
        )
        val moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequest(command)

        val resultDetail = MoneyChangingResultDetail(
            moneyChangingRequestId = moneyChangingRequest.moneyChangingRequestId!!,
            moneyChangingType = moneyChangingRequest.changingType,
            moneyChangingStatus = moneyChangingRequest.changingMoneyStatus,
            amount = moneyChangingRequest.changingMoneyAmount
        )

        return ResponseEntity(resultDetail, HttpStatus.CREATED)
    }
}
