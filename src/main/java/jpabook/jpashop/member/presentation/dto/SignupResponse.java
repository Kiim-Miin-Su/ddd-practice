package jpabook.jpashop.member.presentation.dto;

import jpabook.jpashop.member.application.dto.MemberView;

public record SignupResponse(
		String username,
		String email,
		MemberAddressResponse memberAddressResponse
) {
	public static SignupResponse from(MemberView memberView) {
		return new SignupResponse(memberView.username(), memberView.email(), MemberAddressResponse.from(memberView.address()));
	}
}
