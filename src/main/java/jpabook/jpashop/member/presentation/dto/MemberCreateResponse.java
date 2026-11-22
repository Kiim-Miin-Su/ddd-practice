package jpabook.jpashop.member.presentation.dto;

import jpabook.jpashop.member.domain.Member;

public record MemberCreateResponse(
		Long id,
		String username,
		AddressResponse addressResponse
) {
	public static MemberCreateResponse from(Member member) {
		return new MemberCreateResponse(member.getId(), member.getUsername(), AddressResponse.from(member.getAddress()));
	}
}
