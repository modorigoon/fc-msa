package me.modorigoon.pay.money

import com.fasterxml.jackson.databind.ObjectMapper
import me.modorigoon.pay.money.adapter.`in`.web.IncreaseMoneyChangingRequest
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
class RequestMoneyChangingControllerTest(
    private val mockMvc: MockMvc,
    private val mapper: ObjectMapper
) {

    @Test
    fun increaseMoneyTest() {
        val request = IncreaseMoneyChangingRequest(targetMembershipId = 1, amount = 1000)

        mockMvc.perform(
            MockMvcRequestBuilders.post("/money/increase")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))
        ).andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(
                MockMvcResultMatchers.jsonPath("$.amount", request.amount).exists()
            )
    }
}
