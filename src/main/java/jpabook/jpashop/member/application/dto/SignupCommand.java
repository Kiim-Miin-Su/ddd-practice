package jpabook.jpashop.member.application.dto;

import jpabook.jpashop.member.domain.Member;
import jpabook.jpashop.member.domain.vo.Address;

public record SignupCommand(String username,
                            String password,
                            String email,
                            String city,
                            String street,
                            String zipcode) {
	public Member toEntity(String passwordHash) {
		return Member.create(this.username, passwordHash, this.email, Address.of(this.city, this.street, this.zipcode));
	}
}
