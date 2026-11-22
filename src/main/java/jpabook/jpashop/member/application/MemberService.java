package jpabook.jpashop.member.application;

import jpabook.jpashop.member.domain.Member;
import jpabook.jpashop.member.domain.MemberRepository;
import jpabook.jpashop.member.domain.vo.Address;
import jpabook.jpashop.member.presentation.dto.MemberCreateRequest;
import jpabook.jpashop.member.presentation.dto.MemberCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberCreateResponse signup(MemberCreateRequest dto) {
		Member member = Member.create(dto.username(), Address.of(dto.city(), dto.street(), dto.zipcode()));
		this.memberRepository.save(member);

		return MemberCreateResponse.from(member);
	}
}
