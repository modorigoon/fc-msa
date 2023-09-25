package me.modorigoon.pay.membership

import com.fasterxml.jackson.databind.ObjectMapper
import me.modorigoon.pay.membership.adapter.`in`.web.RegisterMemberShipRequest
import me.modorigoon.pay.membership.domain.Membership
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@EnableMockMvc
@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class RegisterMembershipControllerTest(
    private val mockMvc: MockMvc,
    private val mapper: ObjectMapper
) {

    @Test
    fun testRegisterMembership() {
        val request = RegisterMemberShipRequest(
            name = "김복동",
            address = "강남구 신사동",
            email = "modorigoon@gmail.com",
            false
        )
        val expect = Membership(
            membershipId = 1L,
            name = request.name,
            address = request.address,
            email = request.email,
            isValid = true,
            isCorp = request.corp
        )

        mockMvc.perform(
            MockMvcRequestBuilders.post("/membership/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))
        ).andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(expect)))

    }
}
