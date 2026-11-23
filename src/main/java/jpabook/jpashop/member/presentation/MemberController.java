package jpabook.jpashop.member.presentation;

import jakarta.validation.Valid;
import jpabook.jpashop.common.response.ApiResponse;
import jpabook.jpashop.member.application.MemberService;
import jpabook.jpashop.member.presentation.dto.SignupRequest;
import jpabook.jpashop.member.presentation.dto.SignupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<ApiResponse<SignupResponse>> signup(@RequestBody @Valid SignupRequest request) {
		SignupResponse signupResponse = SignupResponse.from(this.memberService.signup(request.toCommand())); // request -> command -> [entity] -> view -> response

		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(signupResponse));
	}

}
