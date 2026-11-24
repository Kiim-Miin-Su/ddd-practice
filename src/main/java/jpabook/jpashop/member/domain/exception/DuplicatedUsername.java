package jpabook.jpashop.member.domain.exception;

public class DuplicatedUsername extends MemberException {
	public DuplicatedUsername() {
		super(MemberErrorCode.DUPLICATED_USERNAME, MemberErrorCode.DUPLICATED_USERNAME.getMessage());
	}

	public DuplicatedUsername(String message) {
		super(MemberErrorCode.DUPLICATED_USERNAME, message);
	}
}
