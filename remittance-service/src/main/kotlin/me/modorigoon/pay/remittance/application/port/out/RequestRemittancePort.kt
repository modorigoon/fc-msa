package me.modorigoon.pay.remittance.application.port.out

import me.modorigoon.pay.remittance.application.port.`in`.RequestRemittanceCommand
import me.modorigoon.pay.remittance.domain.RemittanceRequest


interface RequestRemittancePort {

    fun saveRemittanceRequestHistory(request: RemittanceRequest): RemittanceRequest
}
