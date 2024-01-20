package com.tistory.jaimemin.effectivejava.ch01.item05.springioc;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tistory.jaimemin.effectivejava.ch01.item05.Dictionary;

@Component
public class SpringDictionary implements Dictionary {

	@Override
	public boolean contains(String word) {
		System.out.println("contains " + word);
		return false;
	}

	@Override
	public List<String> closeWordsTo(String typo) {
		return null;
	}
}
