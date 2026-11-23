package jpabook.jpashop.member.application.dto;

import jpabook.jpashop.member.domain.Member;
import jpabook.jpashop.member.domain.vo.Address;

public record MemberView(String username, String email, Address address) {

	public static MemberView from(Member member) {
		return new MemberView(member.getUsername(), member.getEmail(), member.getAddress());
	}
}
