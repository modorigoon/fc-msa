package me.modorigoon.pay.money.application.usecase

import me.modorigoon.pay.common.SelfValidating
import javax.validation.constraints.NotNull


data class CreateMemberMoneyCommand(
    @field:NotNull val membershipId: Long
) : SelfValidating<CreateMemberMoneyCommand>() {

    init {
        this.validateSelf()
    }
}
