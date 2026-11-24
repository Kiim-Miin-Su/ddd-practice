package jpabook.jpashop.member;

import jpabook.jpashop.member.application.MemberService;
import jpabook.jpashop.member.application.dto.MemberView;
import jpabook.jpashop.member.domain.MemberRepository;
import jpabook.jpashop.member.domain.exception.DuplicatedEmail;
import jpabook.jpashop.member.domain.exception.DuplicatedUsername;
import jpabook.jpashop.member.presentation.dto.SignupRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(properties = {
		"spring.datasource.url=jdbc:h2:mem:jpashop-member-test",
		"spring.jpa.hibernate.ddl-auto=create-drop"
})
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberService memberService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@AfterEach
	public void cleanUp() {
		this.memberRepository.deleteAll();
	}

	@Test
	@Transactional
	public void testMember() {
		// given
		SignupRequest request = new SignupRequest("memberA", "12345", "kms545487@gmail.com", "Seoul", "Wangsibni", "54321");

		// when
		MemberView member = this.memberService.signup(request.toCommand());

		// then
		Assertions.assertEquals("memberA", member.username());
		Assertions.assertEquals("Seoul", member.address().getCity());
		Assertions.assertTrue(this.passwordEncoder.matches("12345", this.memberRepository.findByUsername("memberA").get().getPassword()));
	}

	@Test
	@Transactional
	public void duplicatedUsernameMember() throws DuplicatedUsername {
		// given
		SignupRequest request1 = new SignupRequest("minsu", "12345", "kms545487@gmail.com", "Seoul", "Wangsibni", "54321");
		SignupRequest request2 = new SignupRequest("minsu", "09876", "test@gmail.com", "Gwanju", "Hakdong", "54321");

		// when
		MemberView member1 = this.memberService.signup(request1.toCommand());

		// then
		Assertions.assertEquals("minsu", member1.username());
		Assertions.assertThrows(DuplicatedUsername.class, () -> this.memberService.signup(request2.toCommand()));
		Assertions.assertTrue(this.memberRepository.existsByUsername("minsu"));
		Assertions.assertFalse(this.memberRepository.existsByUsername("leet-cat"));
	}

	@Test
	@Transactional
	public void duplicatedEmailMember() throws Exception {
		// given
		SignupRequest request1 = new SignupRequest("minsu", "12345", "test@gmail.com", "Seoul", "Wangsibni", "54321");
		SignupRequest request2 = new SignupRequest("kiim", "09876", "test@gmail.com", "Gwanju", "Hakdong", "54321");

		// when
		MemberView member1 = this.memberService.signup(request1.toCommand());

		// then
		Assertions.assertEquals("test@gmail.com", member1.email());
		Assertions.assertThrows(DuplicatedEmail.class, () -> this.memberService.signup(request2.toCommand()));
		Assertions.assertTrue(this.memberRepository.existsByEmail("test@gmail.com"));
		Assertions.assertFalse(this.memberRepository.existsByEmail("leet-cat@gmail.com"));
	}
}
