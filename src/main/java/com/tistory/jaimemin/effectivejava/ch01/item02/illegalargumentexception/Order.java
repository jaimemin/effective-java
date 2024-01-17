package com.tistory.jaimemin.effectivejava.ch01.item02.illegalargumentexception;

import java.time.LocalDate;

public class Order {

	/**
	 * 보통은 CheckedException 만 표기
	 * UncheckedException 을 다 명시하면 오히려 가독성 저하
	 */
	public void updateDeliveryDate(LocalDate deliveryDate) {
		if (deliveryDate == null) {
			throw new NullPointerException("deliveryDate can't be null");
		}

		if (deliveryDate.isBefore(LocalDate.now())) {
			/**
			 * 과거로 배송 불가
			 *
			 * 최소한 어떤 매개변수가 잘 못 되었는지 전달하는게 좋음 (deliveryDate)
			 */
			throw new IllegalArgumentException("deliveryDate can't be earlier than " + LocalDate.now());
		}

		// 배송 날짜 업데이트
	}
}
