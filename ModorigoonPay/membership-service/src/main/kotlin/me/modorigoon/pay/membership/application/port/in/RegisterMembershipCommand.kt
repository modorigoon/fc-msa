package me.modorigoon.pay.membership.application.port.`in`

import me.modorigoon.pay.membership.common.SelfValidating
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


data class RegisterMembershipCommand(
    @field:NotNull @field:NotBlank val name: String,
    @field:NotNull @field:NotBlank val email: String,
    @field:NotNull @field:NotBlank val address: String,
    @field:AssertTrue val isValid: Boolean,
    @field:NotNull val isCorp: Boolean
) : SelfValidating<RegisterMembershipCommand>() {

    init {
        this.validateSelf()
    }
}
