package me.modorigoon.pay.membership.adapter.out.persistance

import me.modorigoon.pay.common.PersistenceAdapter
import me.modorigoon.pay.membership.application.port.out.FindMembershipPort
import me.modorigoon.pay.membership.application.port.out.ModifyMembershipPort
import me.modorigoon.pay.membership.application.port.out.RegisterMembershipPort
import me.modorigoon.pay.membership.domain.Membership


@PersistenceAdapter
class MembershipPersistenceAdapter(
    val springDataMembershipRepository: SpringDataMembershipRepository,
    val membershipMapper: MembershipMapper
) : RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    override fun createMembership(
        name: String, email: String, address: String, isValid: Boolean, isCorp: Boolean
    ): Membership {
        val membershipEntity = springDataMembershipRepository.save(
            MembershipJpaEntity(
                membershipId = null,
                name = name,
                email = email,
                address = address,
                isValid = isValid,
                isCorp = isCorp
            )
        )

        return membershipMapper.mapToDomainEntity(membershipEntity)
    }

    override fun findMembershipById(id: Long): Membership {
        val membershipEntity = springDataMembershipRepository.findById(id).get()
        return membershipMapper.mapToDomainEntity(membershipEntity)
    }

    override fun modifyMembership(
        id: Long, name: String, email: String, address: String, isValid: Boolean, isCorp: Boolean
    ): Membership {
        val membershipEntity =
            springDataMembershipRepository.findById(id).orElseThrow { NullPointerException("user not found.") }
        val savedMembershipEntity = springDataMembershipRepository.save(
            membershipEntity.copy(
                membershipId = id,
                name = name,
                email = email,
                address = address,
                isValid = isValid,
                isCorp = isCorp
            )
        )
        return membershipMapper.mapToDomainEntity(savedMembershipEntity)
    }
}
