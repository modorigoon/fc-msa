package me.modorigoon.pay.money.application.port.`in`

import me.modorigoon.pay.common.CountDownLatchManager
import me.modorigoon.pay.common.RechargingMoneyTask
import me.modorigoon.pay.common.SubTask
import me.modorigoon.pay.common.UseCase
import me.modorigoon.pay.money.application.port.out.GetMembershipPort
import me.modorigoon.pay.money.application.port.out.IncreaseMoneyPort
import me.modorigoon.pay.money.application.port.out.SendRechargingMoneyTaskPort
import me.modorigoon.pay.money.application.usecase.IncreaseMoneyRequestCommand
import me.modorigoon.pay.money.application.usecase.IncreaseMoneyRequestUseCase
import me.modorigoon.pay.money.domain.MoneyChangingRequest
import java.util.UUID


@UseCase
class IncreaseMoneyRequestService(
    val increaseMoneyPort: IncreaseMoneyPort,
    val getMembershipPort: GetMembershipPort,
    val sendRechargingMoneyTaskPort: SendRechargingMoneyTaskPort,
    val countDownLatchManager: CountDownLatchManager
) : IncreaseMoneyRequestUseCase {

    override fun increaseMoneyRequest(command: IncreaseMoneyRequestCommand): MoneyChangingRequest {

        getMembershipPort.getMembership(command.targetMembershipId)
            ?: throw NullPointerException("Target member not found.")

        increaseMoneyPort.increaseMoney(command.targetMembershipId, command.amount)

        return increaseMoneyPort.createMoneyChangingRequest(
            targetMembershipId = command.targetMembershipId,
            moneyChangingType = 1,
            changingMoneyAmount = command.amount,
            moneyChangingStatus = 1,
            uuid = UUID.randomUUID().toString()
        )
    }

    override fun increaseMoneyRequestAsync(command: IncreaseMoneyRequestCommand): MoneyChangingRequest? {
        val memberValidationSubTask = SubTask(
            membershipId = command.targetMembershipId,
            subTaskName = "valid_member_task",
            taskType = "MEMBERSHIP",
            status = "READY"
        )

        val bankingValidationSubTask = SubTask(
            membershipId = command.targetMembershipId,
            subTaskName = "valid_banking_account_task",
            taskType = "BANKING",
            status = "READY"
        )

        val subTaskList = listOf(memberValidationSubTask, bankingValidationSubTask)

        val rechargingMoneyTask = RechargingMoneyTask(
            taskId = UUID.randomUUID().toString(),
            taskName = "increase_money_task",
            subTaskList = subTaskList,
            moneyAmount = command.amount,
            membershipId = command.targetMembershipId,
            toBankName = "Hana",
            toBankAccountNumber = "X112233"
        )

        sendRechargingMoneyTaskPort.sendRechargingMoneyTask(rechargingMoneyTask)

        countDownLatchManager.getCountDownLatch(rechargingMoneyTask.taskId).await()

        val result = countDownLatchManager.getDataForKey(rechargingMoneyTask.taskId)
        if (result != "SUCCESS") {
            return null
        }

        return increaseMoneyRequest(command)
    }
}
