package jpabook.jpashop;

import jpabook.jpashop.member.domain.Member;
import jpabook.jpashop.member.domain.MemberRepository;
import jpabook.jpashop.member.domain.vo.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest(properties = {
		"spring.datasource.url=jdbc:h2:mem:jpashop-member-test",
		"spring.jpa.hibernate.ddl-auto=create-drop"
})
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void testMember() {
		// given
		Member member = Member.create("memberA", Address.of("Seoul", "Wangsimli", "12345"));

		// when
		Long savedId = memberRepository.save(member);
		Member foundMember = memberRepository.findById(savedId).orElseThrow();

		// then
		Assertions.assertNotNull(savedId);
		Assertions.assertEquals(savedId, foundMember.getId());
		Assertions.assertEquals("memberA", foundMember.getUsername());
		Assertions.assertEquals("Seoul", foundMember.getAddress().getCity());
		Assertions.assertEquals("Wangsimli", foundMember.getAddress().getStreet());
		Assertions.assertEquals("12345", foundMember.getAddress().getZipcode());
	} // end of testMember();

	@Test
	public void noNameMember() {
		// given
		Member member = Member.create(null, Address.of("Seoul", "Wangsimli", "12345"));

		// then
		Assertions.assertThrows(DataIntegrityViolationException.class, () -> memberRepository.save(member));
	}

} // end of MemberRepositoryTest{};
