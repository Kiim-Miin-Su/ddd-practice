package jpabook.jpashop.item.domain;

import jakarta.persistence.*;
import jpabook.jpashop.order.domain.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;

	@OneToMany(mappedBy = "item")
	private List<OrderItem> orderItems = new ArrayList<>();

	private String name;
	private Integer price;
	private int stockQuantity;

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new  ArrayList<>();
}
