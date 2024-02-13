package com.tistory.jaimemin.effectivejava.ch02.item02.builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChildTest {

	/**
	 * a 필드는 @NonNull
	 */
	@Test
	void testNonNull() {
		assertThrows(
			NullPointerException.class,
			() -> {
				Child child = Child.builder()
					.b(2)
					.c(3)
					.d(4)
					.e(5)
					.build();
			}
		);
	}
}