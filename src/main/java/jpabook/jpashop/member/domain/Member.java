package jpabook.jpashop.member.domain;

import jakarta.persistence.*;
import jpabook.jpashop.member.domain.vo.Address;
import jpabook.jpashop.order.domain.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(nullable = false)
	private String username;

	@Embedded
	@Column(nullable = false)
	private Address address;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();

	public static Member create(String username, Address address) {
		Member member = new Member();
		member.username = username;
		member.address = address;

		return member;
	}
}
