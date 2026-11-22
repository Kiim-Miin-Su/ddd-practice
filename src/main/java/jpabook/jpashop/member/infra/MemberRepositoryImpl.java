package jpabook.jpashop.member.infra;

import jakarta.persistence.EntityNotFoundException;
import jpabook.jpashop.member.domain.Member;
import jpabook.jpashop.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberRepositoryImpl implements MemberRepository { // MemberRepository 구현

	private final MemberJpaRepository memberJpaRepository; // MemberJpaRepository로 구현: 나중에 갈아낄 수 있음.

	@Override
	public Long save(Member member) {
		return this.memberJpaRepository.save(member).getId();
	}

	@Override
	public Optional<Member> findById(Long id) {
		return this.memberJpaRepository.findById(id);
	}

	@Override
	@Transactional
	public void deleteById(Long id) throws EntityNotFoundException {
		Member foundMember = this.memberJpaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("member not found"));

		this.memberJpaRepository.deleteById(id);
		log.info("%s was deleted".formatted(foundMember.getUsername()));
	}

}
