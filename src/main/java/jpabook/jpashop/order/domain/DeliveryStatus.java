package jpabook.jpashop.order.domain;

public enum DeliveryStatus {
	READY, COMPLETE;

	private boolean canTransitionTo(DeliveryStatus next) {

		return switch (this) {
			case READY -> next == DeliveryStatus.COMPLETE;
			case COMPLETE -> false;
		};

	} // end of canTransitionTo();

}
