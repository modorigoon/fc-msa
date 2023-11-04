package me.modorigoon.pay.money.application.usecase


fun interface CreateMemberMoneyUseCase {

    fun createMemberMoney(command: CreateMemberMoneyCommand)
}
