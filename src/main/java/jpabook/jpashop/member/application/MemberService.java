package jpabook.jpashop.member.application;

import jpabook.jpashop.member.application.dto.MemberView;
import jpabook.jpashop.member.application.dto.SignupCommand;
import jpabook.jpashop.member.domain.MemberRepository;
import jpabook.jpashop.member.domain.exception.DuplicatedEmail;
import jpabook.jpashop.member.domain.exception.DuplicatedUsername;
import jpabook.jpashop.member.domain.exception.MemberErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	public MemberView signup(SignupCommand command) {
		if (this.memberRepository.existsByUsername(command.username()))
			throw new DuplicatedUsername("%s: %s".formatted(MemberErrorCode.DUPLICATED_USERNAME.getMessage(), command.username()));
		if (this.memberRepository.existsByEmail(command.email()))
			throw new DuplicatedEmail("%s: %s".formatted(MemberErrorCode.DUPLICATED_EMAIL.getMessage(), command.email()));

		String passwordHash = this.passwordEncoder.encode(command.password());

		return MemberView.from(this.memberRepository.register(command.toEntity(passwordHash)));
	}
}
