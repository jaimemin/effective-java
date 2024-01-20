package com.tistory.jaimemin.effectivejava.ch01.item05.factorymethod;

import com.tistory.jaimemin.effectivejava.ch01.item05.Dictionary;
import com.tistory.jaimemin.effectivejava.ch01.item05.MockDictionary;

public class MockDictionaryFactory implements DictionaryFactory {

	@Override
	public Dictionary getDictionary() {
		return new MockDictionary();
	}
}
