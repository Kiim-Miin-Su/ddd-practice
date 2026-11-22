package jpabook.jpashop.member.application;

import jpabook.jpashop.member.domain.Member;
import jpabook.jpashop.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public Member signup(Member member) {
		Long savedId = this.memberRepository.save(member);

		return this.memberRepository.findById(savedId).orElseThrow(IllegalStateException::new);
	}
}
