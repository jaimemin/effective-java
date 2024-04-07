package com.tistory.jaimemin.effectivejava.ch11.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Concurrent canonicalizing map atop ConcurrentMap - Pages 273-274
public class Intern {

	// Concurrent canonicalizing map atop ConcurrentMap - not optimal
	private static final ConcurrentMap<String, String> map =
		new ConcurrentHashMap<>();

	// public static String intern(String s) {
	// 	String previousValue = map.putIfAbsent(s, s);
	// 	return previousValue == null ? s : previousValue;
	// }

	// Concurrent canonicalizing map atop ConcurrentMap - faster!
	public static String intern(String s) {
		String result = map.get(s);

		if (result == null) {
			result = map.putIfAbsent(s, s);

			if (result == null) {
				result = s;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		String a = "a";
		String b = a.intern();

		System.out.println(a == b);
		long end = System.nanoTime();
		System.out.println(String.format("String.intern() 실행 시간: %d", end - start));

		start = System.nanoTime();
		String c = "c";
		String d = intern(c);

		System.out.println(c == d);
		end = System.nanoTime();
		System.out.println(String.format("ConcurrentHashMap으로 구현한 intern() 실행 시간: %d", end - start));
	}
}
