package com.tistory.jaimemin.effectivejava.ch05.item28.safevarags;

import java.util.List;

public class SafeVaragsExample {

	/**
	 * @SafeVarargs는 단순히 unchecked warning 없애는 용도
	 * 어노테이션을 붙인다고 해서 런타임 에러가 방지되는 것은 아님
	 * 가급적 Suppressed warning을 붙여야하는 코드 작성을 지양
	 */
	//    @SafeVarargs // Not actually safe!
	static void notSafe(List<String>... stringLists) {
		Object[] array = stringLists; // List<String>... => List[], 그리고 배열은 공변이니까.
		List<Integer> tmpList = List.of(42);
		array[0] = tmpList; // Semantically invalid, but compiles without warnings
		String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
	}

	@SafeVarargs
	static <T> void safe(T... values) {
		for (T value : values) {
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		SafeVaragsExample.safe("a", "b", "c");
		SafeVaragsExample.notSafe(List.of("a", "b", "c"));
	}

}
