package jpabook.jpashop.member.presentation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jpabook.jpashop.member.application.dto.SignupCommand;

public record SignupRequest(
		@NotBlank
		String username,

		@NotBlank
		String password,

		@NotBlank
		@Email
		String email,

		String city,
		String street,
		String zipcode
) {
	public SignupCommand toCommand() {
		return new SignupCommand(username, password, email, city, street, zipcode);
	}
}
