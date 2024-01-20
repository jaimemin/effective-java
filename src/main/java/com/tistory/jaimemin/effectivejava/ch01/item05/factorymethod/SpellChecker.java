package com.tistory.jaimemin.effectivejava.ch01.item05.factorymethod;

import java.util.List;

import com.tistory.jaimemin.effectivejava.ch01.item05.Dictionary;

/**
 * 클라이언트 코드
 * 확장은 열려있고 변경은 닫혀 있음
 * OCP
 */
public class SpellChecker {

	// product interface
	private Dictionary dictionary;

	public SpellChecker(DictionaryFactory dictionaryFactory) {
		this.dictionary = dictionaryFactory.getDictionary();
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
