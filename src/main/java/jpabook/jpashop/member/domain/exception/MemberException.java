package jpabook.jpashop.member.domain.exception;

import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {
	private final MemberErrorCode errorCode;

	public MemberException(MemberErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public MemberException(MemberErrorCode errorCode) {
		super(errorCode.getMessage()); // default message
		this.errorCode = errorCode;
	}
}
