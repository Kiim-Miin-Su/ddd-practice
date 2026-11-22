package jpabook.jpashop.member.infra;

import jpabook.jpashop.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
