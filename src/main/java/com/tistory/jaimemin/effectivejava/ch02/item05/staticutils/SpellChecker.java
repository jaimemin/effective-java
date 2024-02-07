package com.tistory.jaimemin.effectivejava.ch02.item05.staticutils;

import java.util.List;

import com.tistory.jaimemin.effectivejava.ch02.item05.DefaultDictionary;
import com.tistory.jaimemin.effectivejava.ch02.item05.Dictionary;

public class SpellChecker {

	/**
	 * 사전에 따라 동작이 달라질 수 있음
	 * 그런데 이런 형식으로는 사전을 바꿔넣을 수 없음
	 * dictionary 를 만드는데 cpu 도 많이 쓰고 메모리도 많이 쓴다고 가정 (비싼 작업)
	 * 테스트할 때마다 dictionary 를 무조건 만드는 문제
	 * 유연하지 않기 때문에 테스트 코드 작성하기 힘듬
	 * <p>
	 * 원인: 자원을 직접 명시했기 때문에
	 */
	private static final Dictionary dictionary = new DefaultDictionary();

	private SpellChecker() {
	}

	public static boolean isValid(String word) {
		// TODO 여기 SpellChecker 코드
		return dictionary.contains(word);
	}

	public static List<String> suggestions(String typo) {
		// TODO 여기 SpellChecker 코드
		return dictionary.closeWordsTo(typo);
	}
}
