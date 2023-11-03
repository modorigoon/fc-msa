package me.modorigoon.pay.remittance.adapter.out.service.money

import me.modorigoon.pay.common.ExternalSystemAdapter
import me.modorigoon.pay.remittance.application.port.out.money.MoneyInfo
import me.modorigoon.pay.remittance.application.port.out.money.MoneyPort


@ExternalSystemAdapter
class MoneyServiceAdapter : MoneyPort {

    override fun getMoneyInfo(membershipId: Long): MoneyInfo? {
        return null
    }

    override fun requestMoneyRecharging(membershipId: Long, amount: Int): Boolean {
        return true
    }

    override fun requestMoneyIncrease(membershipId: Long, amount: Int): Boolean {
        return true
    }

    override fun requestMoneyDecrease(membershipId: Long, amount: Int): Boolean {
        return true
    }
}
