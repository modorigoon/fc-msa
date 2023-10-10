package me.modorigoon.pay.money.application.usecase

import me.modorigoon.pay.common.SelfValidating
import javax.validation.constraints.NotNull


data class IncreaseMoneyRequestCommand(
    @field:NotNull val targetMembershipId: Long,
    @field:NotNull val amount: Int
) : SelfValidating<IncreaseMoneyRequestCommand>() {

    init {
        this.validateSelf()
    }
}
