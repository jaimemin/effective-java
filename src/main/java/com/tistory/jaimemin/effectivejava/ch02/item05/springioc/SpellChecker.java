package com.tistory.jaimemin.effectivejava.ch02.item05.springioc;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tistory.jaimemin.effectivejava.ch02.item05.Dictionary;

@Component
public class SpellChecker {

	private Dictionary dictionary;

	public SpellChecker(Dictionary dictionary) {
		this.dictionary = dictionary;
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