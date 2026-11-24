package jpabook.jpashop.member.infra;

import jpabook.jpashop.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
	public Optional<Member> findByUsername(String username);

	public Optional<Member> findByEmail(String email);

	public boolean existsByUsername(String username);

	public boolean existsByEmail(String email);

	public void deleteAll();
}
