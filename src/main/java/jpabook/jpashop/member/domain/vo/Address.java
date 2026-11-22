package jpabook.jpashop.member.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA Reflection
@AllArgsConstructor(access = AccessLevel.PRIVATE) // member method of()
public class Address {

	private String city;
	private String street;
	private String zipcode;

	public static Address of(String city, String street, String zipcode) {
		return new Address(city, street, zipcode);
	}
}
