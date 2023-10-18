package me.modorigoon.pay.money.application.port.out

import me.modorigoon.pay.common.RechargingMoneyTask


fun interface SendRechargingMoneyTaskPort {

    fun sendRechargingMoneyTask(task: RechargingMoneyTask)
}
