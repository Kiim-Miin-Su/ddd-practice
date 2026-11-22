package jpabook.jpashop.member.presentation;

import jpabook.jpashop.member.application.MemberService;
import jpabook.jpashop.member.domain.Member;
import jpabook.jpashop.member.presentation.dto.MemberCreateRequest;
import jpabook.jpashop.member.presentation.dto.MemberCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/signup")
	public MemberCreateResponse signup(@RequestBody MemberCreateRequest request) {
		Member saved = this.memberService.signup(request.to());
		return MemberCreateResponse.from(saved);
	}

}
