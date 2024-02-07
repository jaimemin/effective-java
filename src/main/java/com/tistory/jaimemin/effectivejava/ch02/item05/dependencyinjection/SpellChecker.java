package com.tistory.jaimemin.effectivejava.ch02.item05.dependencyinjection;

import java.util.List;
import java.util.function.Supplier;

import com.tistory.jaimemin.effectivejava.ch02.item05.Dictionary;

public class SpellChecker {

	private final Dictionary dictionary;

	/**
	 * DI를 사용할 경우 dictionary 가 바뀐다고 해도 모든 코드 재사용 가능
	 * 전재: dictionary 가 interface 일 경우
	 * 단순 클래스일 경우 규약이 없기 때문에 KoreanDictionary, EnglishDictionary 는
	 * 각각 다른 메서드를 가질 수 있기 때문에 인터페이스여야 함
	 */
	public SpellChecker(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	/**
	 * 팩토리 메서드 패턴
	 * <p>
	 * Dictionary 를 생산하는 과정이 복잡할 경우
	 * 중간 단계를 더욱 더 추상화
	 */
	public SpellChecker(Supplier<? extends Dictionary> dictionarySupplier) {
		this.dictionary = dictionarySupplier.get();
	}

	public boolean isValid(String word) {
		// TODO 여기 SpellChecker 코드
		return dictionary.contains(word);
	}

	public List<String> suggestions(String typo) {
		// TODO 여기 SpellChecker 코드
		return dictionary.closeWordsTo(typo);
	}
}