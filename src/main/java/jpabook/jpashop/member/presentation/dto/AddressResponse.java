package jpabook.jpashop.member.presentation.dto;

import jpabook.jpashop.member.domain.vo.Address;

public record AddressResponse(String city, String street, String zipcode) {

	public static AddressResponse from(Address address) {
		if (address == null) return null;
		return new AddressResponse(address.getCity(), address.getStreet(), address.getZipcode());
	}
}
