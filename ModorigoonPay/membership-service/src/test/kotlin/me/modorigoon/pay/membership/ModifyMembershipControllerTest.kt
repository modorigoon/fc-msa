package me.modorigoon.pay.membership

import com.fasterxml.jackson.databind.ObjectMapper
import me.modorigoon.pay.membership.adapter.`in`.web.ModifyMembershipRequest
import me.modorigoon.pay.membership.application.port.out.RegisterMembershipPort
import me.modorigoon.pay.membership.domain.Membership
import org.junit.jupiter.api.BeforeEach
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
class ModifyMembershipControllerTest(
    private val mockMvc: MockMvc,
    private val mapper: ObjectMapper,
    private val registerMembershipPort: RegisterMembershipPort
) {

    lateinit var testAlreadyRegisteredMembership: Membership

    @Test
    fun testModifyMembership() {
        val request = ModifyMembershipRequest(
            membershipId = testAlreadyRegisteredMembership.membershipId!!,
            name = "김방구",
            address = "강북구 미아동",
            email = "modorigoon@aws.com",
            corp = true
        )
        val expect = Membership(
            membershipId = testAlreadyRegisteredMembership.membershipId,
            name = request.name,
            address = request.address,
            email = request.email,
            isValid = true,
            isCorp = request.corp
        )

        mockMvc.perform(
            MockMvcRequestBuilders.put("/membership/modify")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(expect)))
    }

    @BeforeEach
    fun before() {
        testAlreadyRegisteredMembership = registerMembershipPort.createMembership(
            name = "김복동",
            email = "modorigoon@gmail.com",
            address = "강남구 신사동",
            isValid = true,
            isCorp = true
        )
    }
}
