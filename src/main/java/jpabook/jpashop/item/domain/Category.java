package jpabook.jpashop.item.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToMany
	@JoinTable(name = "category_item",
			joinColumns = @JoinColumn(name = "category_id"), // 중간 테이블의 category_id
			inverseJoinColumns = @JoinColumn(name = "item_id") // 반대편
	)
	private List<Item> items = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private List<Category> children = new ArrayList<>();
}
