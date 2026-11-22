package jpabook.jpashop.order.domain;

public enum OrderStatus {
	ORDER, CANCEL;

	public boolean canTransitionTo(OrderStatus next) {

		return switch (this) {
			case ORDER -> next == OrderStatus.CANCEL;
			case CANCEL -> false;
		};

	} // end of canTransitionTo();

} // end of OrderStatus
