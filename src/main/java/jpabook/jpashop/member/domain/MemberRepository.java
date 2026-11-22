package jpabook.jpashop.member.domain;

import java.util.Optional;

public interface MemberRepository {

	public Long save(Member member);

	public Optional<Member> findById(Long id);

	public void deleteById(Long id);

}
