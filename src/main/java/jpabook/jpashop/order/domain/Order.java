package jpabook.jpashop.order.domain;

import jakarta.persistence.*;
import jpabook.jpashop.member.domain.Member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();

	@OneToOne // 주인
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;

	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING) // default = ORDINAL: 숫자로 매핑되는데 중간에 다른 상태가 추가되면 싹다 교체해야 됨.
	private OrderStatus status; // [ORDER, CANCEL]

	private void transitionTo(OrderStatus next) {
		if (!this.status.canTransitionTo(next)) throw new IllegalStateException("this order has been canceled");

		this.status = next;
	}
}
