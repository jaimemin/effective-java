package com.tistory.jaimemin.effectivejava.ch04.item19.constructor;

import java.time.Instant;

// 생성자에서 호출하는 메서드를 재정의했을 때의 문제를 보여준다. (126쪽)

/**
 * Clonable과 Serializable을 상속할 때도 주의 필요
 *
 * 상속을 할 때 고려할 점이 많음
 * 이 때문에 상속을 막는 것도 한 가지 방법
 */
public final class Sub extends Super {
	// 초기화되지 않은 final 필드. 생성자에서 초기화한다.
	private final Instant instant;

	Sub() {
		// 내부적으로 상위 클래스의 생성자가 먼저 호출
		// null이 한번 호출되고
		instant = Instant.now();
	}

	// 재정의 가능 메서드. 상위 클래스의 생성자가 호출한다.
	@Override
	public void overrideMe() {
		System.out.println(instant);
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe(); // 그 다음 인스턴스 호출
	}
}
