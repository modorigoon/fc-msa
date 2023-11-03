package me.modorigoon.pay.money.application.port.out

import me.modorigoon.pay.money.domain.MemberMoney
import me.modorigoon.pay.money.domain.MoneyChangingRequest


interface IncreaseMoneyPort {

    fun createMoneyChangingRequest(
        targetMembershipId: Long, moneyChangingType: Int, changingMoneyAmount: Int, moneyChangingStatus: Int,
        uuid: String
    ): MoneyChangingRequest

    fun increaseMoney(memberId: Long, increaseMoneyAmount: Int): MemberMoney
}
