package me.modorigoon.pay.banking.application.port.`in`

import me.modorigoon.pay.common.SelfValidating
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


data class RequestFirmBankingCommand(
    @field:NotBlank val fromBankName: String,
    @field:NotBlank val fromBankAccountNumber: String,
    @field:NotBlank val toBankName: String,
    @field:NotBlank val toBankAccountNumber: String,
    @field:NotNull val moneyAmount: Int
) : SelfValidating<RequestFirmBankingCommand>() {

    init {
        this.validateSelf()
    }
}
