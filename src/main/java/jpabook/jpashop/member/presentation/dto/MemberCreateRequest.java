package jpabook.jpashop.member.presentation.dto;

import jpabook.jpashop.member.domain.Member;
import jpabook.jpashop.member.domain.vo.Address;

public record MemberCreateRequest(
		String username,
		String city,
		String street,
		String zipcode
) {
	public Member to() {
		return Member.create(username, Address.of(this.city, this.street, this.zipcode));
	}
}
