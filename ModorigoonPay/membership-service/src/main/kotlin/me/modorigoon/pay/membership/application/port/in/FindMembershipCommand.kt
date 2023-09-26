package me.modorigoon.pay.membership.application.port.`in`

import me.modorigoon.pay.common.SelfValidating
import javax.validation.constraints.NotNull


data class FindMembershipCommand(@field:NotNull val membershipId: Long) : SelfValidating<FindMembershipCommand>() {

    init {
        this.validateSelf()
    }
}
