package me.modorigoon.pay.membership.adapter.out.persistance

import me.modorigoon.pay.membership.application.port.out.FindMembershipPort
import me.modorigoon.pay.membership.application.port.out.RegisterMembershipPort
import me.modorigoon.pay.membership.common.PersistenceAdapter
import me.modorigoon.pay.membership.domain.Membership


@PersistenceAdapter
class MembershipPersistenceAdapter(
    val springDataMembershipRepository: SpringDataMembershipRepository,
    val membershipMapper: MembershipMapper
) : RegisterMembershipPort, FindMembershipPort {

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
}
