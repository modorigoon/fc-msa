package me.modorigoon.pay.money.application.usecase

import me.modorigoon.pay.money.domain.MoneyChangingRequest


interface IncreaseMoneyRequestUseCase {

    fun increaseMoneyRequest(command: IncreaseMoneyRequestCommand): MoneyChangingRequest

    fun increaseMoneyRequestAsync(command: IncreaseMoneyRequestCommand): MoneyChangingRequest?
}
