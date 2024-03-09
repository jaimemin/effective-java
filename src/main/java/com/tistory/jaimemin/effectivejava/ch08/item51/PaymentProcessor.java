package com.tistory.jaimemin.effectivejava.ch08.item51;

public class PaymentProcessor {

	public enum PaymentMethod {
		CREDIT_CARD,
		DEBIT_CARD
	}

	// 안 좋은 예
	public void processPayment(double amount, boolean isCreditCard) {
		// 결제 처리 로직
	}

	/**
	 * 권장하는 예
	 * 결제 수단이 늘어날 경우 enum이 훨씬 유연함
	 */
	public void processPayment(double amount, PaymentMethod paymentMethod) {
		// 결제 처리 로직
	}

}

