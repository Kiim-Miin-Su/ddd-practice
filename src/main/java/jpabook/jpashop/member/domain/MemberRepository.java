package jpabook.jpashop.member.domain;

import java.util.Optional;

public interface MemberRepository {

	public Member register(Member member);

	public Optional<Member> findById(Long id);

	public void deleteById(Long id);

	public Optional<Member> findByEmail(String email);

	public Optional<Member> findByUsername(String username);

	public boolean existsByUsername(String username);

	public boolean existsByEmail(String email);

	public void deleteAll();

}
