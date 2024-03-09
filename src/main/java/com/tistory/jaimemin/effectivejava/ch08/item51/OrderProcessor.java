package com.tistory.jaimemin.effectivejava.ch08.item51;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

public class OrderProcessor {

	@Builder(builderMethodName = "")
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	static class Order {

		private String customerName;

		private String address;

		private String productName;

		private int quantity;

		public static OrderBuilder builder(String productName, int quantity) {
			return new OrderBuilder().productName(productName)
				.quantity(quantity);
		}
	}

	// 안 좋은 예
	public void processOrder(String customerName, String address, String productName, int quantity) {
		// 주문 처리 로직
	}

	// 권장하는 예
	public void processOrder(Order order) {
		// 주문 처리 로직
	}

	public static void main(String[] args) {
		Order order = Order.builder("상품", 2)
			.customerName("아무개")
			// address는 생략 가능
			.build();
		OrderProcessor orderProcessor = new OrderProcessor();
		orderProcessor.processOrder(order);
	}
}
