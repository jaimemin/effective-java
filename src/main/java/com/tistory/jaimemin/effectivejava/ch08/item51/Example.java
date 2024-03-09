package com.tistory.jaimemin.effectivejava.ch08.item51;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Example {

	// 안 좋은 예
	public static void badFunc(HashMap<String, String> map) {

	}

	public static void goodFunc(Map<String, String> map) {

	}

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		// Example.badFunc(map);
		Example.goodFunc(map);
	}
}
