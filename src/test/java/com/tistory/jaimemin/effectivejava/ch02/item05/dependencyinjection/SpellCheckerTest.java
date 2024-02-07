package com.tistory.jaimemin.effectivejava.ch02.item05.dependencyinjection;

import org.junit.jupiter.api.Test;

import com.tistory.jaimemin.effectivejava.ch02.item05.DefaultDictionary;

class SpellCheckerTest {

	@Test
	void isValid() {
		/**
		 * 의존 객체 주입을 사용하는 코드의 경우 SpellChecker 의 외부에서
		 * SpellChecker 가 사용하는 리소스를 주입해줄 수 있음
		 *
		 * Dependency Injection
		 *
		 * 장점: SpellChecker의 코드를 그대로 사용하면서도 여러 Dictionary 를 주입 가능
		 * 유연해지고 코드 재사용성 높아짐
		 */
		SpellChecker spellChecker = new SpellChecker(new DefaultDictionary());
		SpellChecker spellChecker1 = new SpellChecker(DefaultDictionary::new);
		SpellChecker spellChecker2 = new SpellChecker(DictionaryFactory::get);
		spellChecker.isValid("test");
	}
}