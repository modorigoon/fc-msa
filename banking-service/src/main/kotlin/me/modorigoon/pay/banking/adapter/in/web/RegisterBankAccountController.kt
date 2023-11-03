package me.modorigoon.pay.banking.adapter.`in`.web

import me.modorigoon.pay.banking.application.port.`in`.RegisterBankAccountCommand
import me.modorigoon.pay.banking.application.port.`in`.RegisterBankAccountUseCase
import me.modorigoon.pay.banking.domain.RegisteredBankAccount
import me.modorigoon.pay.common.WebAdapter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@WebAdapter
@RestController
class RegisterBankAccountController(val registerBankAccountUseCase: RegisterBankAccountUseCase) {

    @PostMapping("/banking/account/register")
    fun registerBankAccount(@RequestBody request: RegisterBankAccountRequest): ResponseEntity<RegisteredBankAccount> =
        ResponseEntity(
            registerBankAccountUseCase.registerBankAccount(
                RegisterBankAccountCommand(
                    membershipId = request.membershipId,
                    bankName = request.bankName,
                    bankAccountNumber = request.bankAccountNumber,
                    linkedStatusIsValid = request.linkedStatusIsValid
                )
            ),
            HttpStatus.CREATED
        )
}
