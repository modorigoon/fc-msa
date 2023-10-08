package me.modorigoon.pay.banking.domain


data class FirmBankingRequest(
    val firmBankingRequestId: Long?,
    val fromBankName: String,
    val fromBankAccountNumber: String,
    val toBankName: String,
    val toBankAccountNumber: String,
    val moneyAmount: Int,
    val firmBankingStatus: Int,
    val uuid: String
) {
    fun toComplete(): FirmBankingRequest =
        this.copy(firmBankingStatus = 1)

    fun toFailed(): FirmBankingRequest =
        this.copy(firmBankingStatus = 2)
}
