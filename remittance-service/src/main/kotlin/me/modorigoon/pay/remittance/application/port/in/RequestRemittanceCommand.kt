package me.modorigoon.pay.remittance.application.port.`in`

import me.modorigoon.pay.common.SelfValidating
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


data class RequestRemittanceCommand(
    @field:NotNull val fromMembershipId: Long,
    @field:NotNull val toMembershipId: Long,
    @field:NotBlank val toBankName: String,
    @field:NotBlank val toBankAccountNumber: String,
    @field:NotNull val remittanceType: Int,
    @field:NotNull val amount: Int
) : SelfValidating<RequestRemittanceCommand>() {

    init {
        this.validateSelf()
    }
}
