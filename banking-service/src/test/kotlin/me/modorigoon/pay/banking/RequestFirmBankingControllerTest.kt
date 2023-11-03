package me.modorigoon.pay.banking

import com.fasterxml.jackson.databind.ObjectMapper
import me.modorigoon.pay.banking.adapter.`in`.web.RequestFirmBankingRequest
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
class RequestFirmBankingControllerTest(
    private val mockMvc: MockMvc,
    private val mapper: ObjectMapper
) {

    @Test
    fun requestFirmBankingTest() {
        val request = RequestFirmBankingRequest(
            fromBankName = "하나",
            fromBankAccountNumber = "AX110",
            toBankName = "우리",
            toBankAccountNumber = "BT236",
            moneyAmount = 33000
        )

        mockMvc.perform(
            MockMvcRequestBuilders.post("/banking/firm-banking/request")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))
        ).andExpect(MockMvcResultMatchers.status().isCreated)
    }
}
