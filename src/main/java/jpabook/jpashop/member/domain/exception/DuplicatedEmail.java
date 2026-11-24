package jpabook.jpashop.member.domain.exception;

public class DuplicatedEmail extends MemberException {
	public DuplicatedEmail() {
		super(MemberErrorCode.DUPLICATED_EMAIL, MemberErrorCode.DUPLICATED_EMAIL.getMessage());
	}

	public DuplicatedEmail(String message) {
		super(MemberErrorCode.DUPLICATED_EMAIL, message);
	}
}
