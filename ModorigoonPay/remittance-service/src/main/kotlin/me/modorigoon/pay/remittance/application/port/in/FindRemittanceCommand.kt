package me.modorigoon.pay.remittance.application.port.`in`

import me.modorigoon.pay.common.SelfValidating
import javax.validation.constraints.NotNull


data class FindRemittanceCommand(
    @field:NotNull val membershipId: Long
) : SelfValidating<FindRemittanceCommand>() {

    init {
        this.validateSelf()
    }
}
