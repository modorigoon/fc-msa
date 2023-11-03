package me.modorigoon.pay.banking.adapter.`in`.web

import me.modorigoon.pay.banking.application.port.`in`.RequestFirmBankingCommand
import me.modorigoon.pay.banking.application.port.`in`.RequestFirmBankingUseCase
import me.modorigoon.pay.banking.domain.FirmBankingRequest
import me.modorigoon.pay.common.WebAdapter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@WebAdapter
@RestController
class RequestFirmBankingController(val requestFirmBankingUseCase: RequestFirmBankingUseCase) {


    @PostMapping("/banking/firm-banking/request")
    fun requestFirmBanking(@RequestBody request: RequestFirmBankingRequest): ResponseEntity<FirmBankingRequest> {
        val command = RequestFirmBankingCommand(
            fromBankName = request.fromBankName,
            fromBankAccountNumber = request.fromBankAccountNumber,
            toBankName = request.toBankName,
            toBankAccountNumber = request.toBankAccountNumber,
            moneyAmount = request.moneyAmount
        )
        val firmBankingRequest = requestFirmBankingUseCase.requestFirmBanking(command)
        return ResponseEntity(firmBankingRequest, HttpStatus.CREATED)
    }
}
