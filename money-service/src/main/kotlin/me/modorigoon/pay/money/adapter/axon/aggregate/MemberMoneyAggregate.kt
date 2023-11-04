package me.modorigoon.pay.money.adapter.axon.aggregate

import me.modorigoon.pay.money.adapter.axon.command.CreateMoneyCommand
import me.modorigoon.pay.money.adapter.axon.event.MemberMoneyCreatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.spring.stereotype.Aggregate


@Aggregate
class MemberMoneyAggregate() {

    @AggregateIdentifier
    var membershipId: Long? = null
    var balance: Int? = null

    @CommandHandler
    constructor(createMoneyCommand: CreateMoneyCommand) : this() {
        println("CreateMoneyCommand: Handler")
        org.axonframework.modelling.command.AggregateLifecycle
            .apply(MemberMoneyCreatedEvent(createMoneyCommand.membershipId))
    }

    @EventSourcingHandler
    fun on(event: MemberMoneyCreatedEvent) {
        membershipId = event.membershipId
        balance = 0
        println("[EventSourcingHandler] MemberMoneyCreatedEvent: $membershipId")
    }
}
