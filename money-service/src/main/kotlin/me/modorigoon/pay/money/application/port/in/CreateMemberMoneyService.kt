package me.modorigoon.pay.money.application.port.`in`

import me.modorigoon.pay.common.UseCase
import me.modorigoon.pay.money.adapter.axon.command.CreateMoneyCommand
import me.modorigoon.pay.money.adapter.axon.event.MemberMoneyCreatedEvent
import me.modorigoon.pay.money.application.usecase.CreateMemberMoneyCommand
import me.modorigoon.pay.money.application.usecase.CreateMemberMoneyUseCase
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.eventhandling.EventHandler


@UseCase
class CreateMemberMoneyService(val commandGateway: CommandGateway) : CreateMemberMoneyUseCase {

    override fun createMemberMoney(command: CreateMemberMoneyCommand) {
        val createMoneyCommand = CreateMoneyCommand(command.membershipId)
        commandGateway.send<CreateMoneyCommand>(createMoneyCommand)
    }

    @EventHandler
    fun on(event: MemberMoneyCreatedEvent) {
        println("Event Handler: $event")
    }
}
