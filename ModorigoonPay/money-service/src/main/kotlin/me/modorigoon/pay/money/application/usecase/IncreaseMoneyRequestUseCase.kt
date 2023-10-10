package me.modorigoon.pay.money.application.usecase

import me.modorigoon.pay.money.domain.MoneyChangingRequest


fun interface IncreaseMoneyRequestUseCase {

    fun increaseMoneyRequest(command: IncreaseMoneyRequestCommand): MoneyChangingRequest
}
