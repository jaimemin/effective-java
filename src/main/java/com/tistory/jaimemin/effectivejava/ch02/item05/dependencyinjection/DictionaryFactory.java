package com.tistory.jaimemin.effectivejava.ch02.item05.dependencyinjection;

import com.tistory.jaimemin.effectivejava.ch02.item05.DefaultDictionary;

public class DictionaryFactory {
	
	public static DefaultDictionary get() {
		return new DefaultDictionary();
	}
}
