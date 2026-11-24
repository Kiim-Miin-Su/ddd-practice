package jpabook.jpashop.member.presentation.dto;

import jpabook.jpashop.member.domain.vo.Address;

public record MemberAddressResponse(String city, String street, String zipcode) {

	public static MemberAddressResponse from(Address address) {
		if (address == null) return null;
		return new MemberAddressResponse(address.getCity(), address.getStreet(), address.getZipcode());
	}
}
