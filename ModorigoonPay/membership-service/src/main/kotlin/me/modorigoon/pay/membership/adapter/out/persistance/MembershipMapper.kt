package me.modorigoon.pay.membership.adapter.out.persistance

import me.modorigoon.pay.membership.domain.Membership
import org.springframework.stereotype.Component


@Component
class MembershipMapper {

    fun mapToDomainEntity(entity: MembershipJpaEntity): Membership = Membership(
        membershipId = entity.membershipId,
        name = entity.name,
        email = entity.email,
        address = entity.address,
        isValid = entity.isValid,
        isCorp = entity.isCorp
    )
}
