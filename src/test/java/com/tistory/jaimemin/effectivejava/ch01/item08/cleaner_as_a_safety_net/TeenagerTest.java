package com.tistory.jaimemin.effectivejava.ch01.item08.cleaner_as_a_safety_net;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TeenagerTest {

	@Test
	@RepeatedTest(10)
	public void testIfGcIsCalled() {
		// Assertions.assertThat(Room.cleanerCalled).isFalse();
		// new Room(99);
		// System.gc();
		//
		// Assertions.assertThat(Room.cleanerCalled).isTrue();
	}

}