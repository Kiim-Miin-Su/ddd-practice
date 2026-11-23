package jpabook.jpashop.member.domain.exception;

public class DuplicatedEmail extends MemberException {
	public DuplicatedEmail(String message) {
		super(MemberErrorCode.DUPLICATED_EMAIL, message);
	}
}
