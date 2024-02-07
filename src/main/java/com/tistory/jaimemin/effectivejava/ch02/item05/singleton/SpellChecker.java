package com.tistory.jaimemin.effectivejava.ch02.item05.singleton;

import java.util.List;

import com.tistory.jaimemin.effectivejava.ch02.item05.DefaultDictionary;
import com.tistory.jaimemin.effectivejava.ch02.item05.Dictionary;

public class SpellChecker {

	/**
	 * 싱글톤의 경우에도 staticutils와 동일한 문제
	 * dictionary 없이는 테스트 불가
	 * 유연성이 떨어지고 재사용성 떨어짐
	 * <p>
	 * isValid 와 suggestions 메서드에 SpellChecker 의 고유 비즈니스 로직이 들어가 있다고 가정
	 * 그렇지 않을 경우 굳이 Wrapping 해서 사용할 이유가 없음
	 * <p>
	 * 한국어 사전, 영어 사전에 따라 각각 다르게 테스트하고 싶을 때
	 * 1. dictionary에 각각 다른 사전을 넣어준다
	 * 2. SpellChecker 상속해서 koreanDictionary, englishDictionary로 넣어주는 방법
	 */
	private final Dictionary dictionary = new DefaultDictionary();

	private SpellChecker() {
	}

	public static final SpellChecker INSTANCE = new SpellChecker();

	public boolean isValid(String word) {
		// TODO 여기 SpellChecker 코드
		return dictionary.contains(word);
	}

	public List<String> suggestions(String typo) {
		// TODO 여기 SpellChecker 코드
		return dictionary.closeWordsTo(typo);
	}
}
