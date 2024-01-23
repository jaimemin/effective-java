package com.tistory.jaimemin.effectivejava.ch01.item08.finalizer_attack;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void 일반_계정() {
		Account account = new Account("jaimemin");
		account.transfer(BigDecimal.valueOf(10.4), "hello");
	}

	@Test
	void 푸틴_계정() throws InterruptedException {
		Account account = null;

		/**
		 * BrokenAccount도 Account를 생성했으므로 부모의 생성자를 호출하지만
		 * 예외를 잡고 코드를 그대로 진행하고 GC가 호출할 경우
		 * BrokenAccount의 finalize가 호출되고 해당 메서드에서 푸틴한테 돈을 보낸다면 호출이 됨
		 *
		 * 막는 방법
		 * 1. Account 상속 허용안할 경우 final class로 선언하면 됨
		 * 2. 상속 구조가 필요한 경우 Account의 finalize() 메서드를 final로 선언하고 overriding 허용을 막음
		 */
		try {
			account = new BrokenAccount("푸틴");
		} catch (Exception exception) {
			System.out.println("예외를 잡고 던지지 않는다");
		}

		System.gc();
		Thread.sleep(3000L);
	}

}