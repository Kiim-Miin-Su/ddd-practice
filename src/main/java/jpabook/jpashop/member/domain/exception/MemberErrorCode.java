package jpabook.jpashop.member.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MemberErrorCode {
	MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 회원이 존재하지 않습니다."),
	DUPLICATED_USERNAME(HttpStatus.CONFLICT, "중복된 아이디의 회원이 존재합니다."),
	DUPLICATED_EMAIL(HttpStatus.CONFLICT, "중복된 이메일의 회원이 존재합니다.");

	private final HttpStatus httpStatus;
	private final String message;

	MemberErrorCode(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
}
