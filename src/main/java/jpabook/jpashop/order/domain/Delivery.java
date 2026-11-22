package jpabook.jpashop.order.domain;

import jakarta.persistence.*;
import jpabook.jpashop.member.domain.vo.Address;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_id")
	private Long id;

	@OneToOne(mappedBy = "delivery") // Order가 주인
	private Order order;

	@Embedded
	private Address address;

	@Enumerated(EnumType.STRING) // default = ORDINAL: 숫자로 매핑되는데 중간에 다른 상태가 추가되면 싹다 교체해야 됨.
	private DeliveryStatus status;
}
