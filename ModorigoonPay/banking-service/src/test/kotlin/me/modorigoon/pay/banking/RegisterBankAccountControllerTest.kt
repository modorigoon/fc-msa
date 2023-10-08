package me.modorigoon.pay.banking

import com.fasterxml.jackson.databind.ObjectMapper
import me.modorigoon.pay.banking.adapter.`in`.web.RegisterBankAccountRequest
import me.modorigoon.pay.banking.domain.RegisteredBankAccount
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@ActiveProfiles("test")
@EnableMockMvc
@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class RegisterBankAccountControllerTest(
    private val mockMvc: MockMvc,
    private val mapper: ObjectMapper
) {

    @Test
    fun testRegisterBankAccount() {
        val request = RegisterBankAccountRequest(
            membershipId = 1L,
            bankName = "하나은행",
            bankAccountNumber = "A1101",
            linkedStatusIsValid = true
        )
        val expect = RegisteredBankAccount(
            registeredBankAccountId = 1L,
            membershipId = request.membershipId,
            bankName = request.bankName,
            bankAccountNumber = request.bankAccountNumber,
            linkedStatusIsValid = request.linkedStatusIsValid
        )

        mockMvc.perform(
            MockMvcRequestBuilders.post("/banking/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))
        ).andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(expect)))
    }
}
