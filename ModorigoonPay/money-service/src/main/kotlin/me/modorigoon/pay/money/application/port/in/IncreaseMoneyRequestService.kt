package me.modorigoon.pay.money.application.port.`in`

import me.modorigoon.pay.common.UseCase
import me.modorigoon.pay.money.application.port.out.IncreaseMoneyPort
import me.modorigoon.pay.money.application.usecase.IncreaseMoneyRequestCommand
import me.modorigoon.pay.money.application.usecase.IncreaseMoneyRequestUseCase
import me.modorigoon.pay.money.domain.MoneyChangingRequest
import java.util.UUID


@UseCase
class IncreaseMoneyRequestService(
    val increaseMoneyPort: IncreaseMoneyPort
) : IncreaseMoneyRequestUseCase {

    override fun increaseMoneyRequest(command: IncreaseMoneyRequestCommand): MoneyChangingRequest {
        increaseMoneyPort.increaseMoney(command.targetMembershipId, command.amount)

        return increaseMoneyPort.createMoneyChangingRequest(
            targetMembershipId = command.targetMembershipId,
            moneyChangingType = 1,
            changingMoneyAmount = command.amount,
            moneyChangingStatus = 1,
            uuid = UUID.randomUUID().toString()
        )
    }
}
