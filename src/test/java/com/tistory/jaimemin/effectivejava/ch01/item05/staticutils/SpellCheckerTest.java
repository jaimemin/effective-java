package com.tistory.jaimemin.effectivejava.ch01.item05.staticutils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {

	@Test
	void isValid() {
		assertTrue(SpellChecker.isValid("test"));
	}
}