package me.modorigoon.pay.remittance.adapter.out.service.banking

import me.modorigoon.pay.common.ExternalSystemAdapter
import me.modorigoon.pay.remittance.application.port.out.banking.BankingInfo
import me.modorigoon.pay.remittance.application.port.out.banking.BankingPort


@ExternalSystemAdapter
class BankingServiceAdapter : BankingPort {

    override fun getMembershipBankingInfo(bankName: String, bankAccountNumber: String): BankingInfo? {
        return null
    }

    override fun requestFirmBanking(bankName: String, bankAccountNumber: String, amount: Int): Boolean {
        return true
    }
}
