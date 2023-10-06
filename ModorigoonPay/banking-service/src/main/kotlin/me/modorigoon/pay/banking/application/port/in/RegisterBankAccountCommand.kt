package me.modorigoon.pay.banking.application.port.`in`

import me.modorigoon.pay.banking.domain.RegisteredBankAccount
import me.modorigoon.pay.common.SelfValidating
import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotBlank


data class RegisterBankAccountCommand(
    @field:NotNull val membershipId: Long,
    @field:NotBlank val bankName: String,
    @field:NotBlank val bankAccountNumber: String,
    @field:NotNull val linkedStatusIsValid: Boolean
) : SelfValidating<RegisteredBankAccount>() {

    init {
        this.validateSelf()
    }
}
