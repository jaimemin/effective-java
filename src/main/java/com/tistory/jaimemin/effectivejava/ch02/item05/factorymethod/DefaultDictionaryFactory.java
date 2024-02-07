package com.tistory.jaimemin.effectivejava.ch02.item05.factorymethod;

import com.tistory.jaimemin.effectivejava.ch02.item05.DefaultDictionary;
import com.tistory.jaimemin.effectivejava.ch02.item05.Dictionary;

public class DefaultDictionaryFactory implements DictionaryFactory {

	@Override
	public Dictionary getDictionary() {
		return new DefaultDictionary();
	}
}
