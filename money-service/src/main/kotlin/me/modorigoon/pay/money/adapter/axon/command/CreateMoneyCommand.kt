package me.modorigoon.pay.money.adapter.axon.command

import org.axonframework.modelling.command.TargetAggregateIdentifier
import javax.validation.constraints.NotNull


data class CreateMoneyCommand(
    @TargetAggregateIdentifier
    @field:NotNull
    val membershipId: Long
)
