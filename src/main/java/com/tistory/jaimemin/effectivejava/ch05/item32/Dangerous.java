package com.tistory.jaimemin.effectivejava.ch05.item32;

import java.util.List;

// 제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않다. (191-192쪽)
public class Dangerous {
	// 코드 32-1 제네릭과 varargs를 혼용하면 타입 안전성이 깨진다! (191-192쪽)

	/**
	 * 제네릭은 성격상 배열하고 안 맞음 (불공변이기 때문)
	 * 컴파일러가 제네릭 배열을 직접 정의하는 것을 막는다 ex) List<String>[] (x)
	 * 하지만 제네릭과 가변인자를 같이 사용하면 제네릭 배열을 만들 수 있음 (컴파일은 되지만 unchecked warning 뜸)
	 * -> Possible heap pollution from parameterized vararg type
	 * -> 컴파일 타임에 타입 안전성 체크도 안되고 런타임에 ClassCastException 발생
	 */
	static void dangerous(List<String>... stringLists) {
		List<Integer> intList = List.of(42);
		Object[] objects = stringLists;
		objects[0] = intList; // 힙 오염 발생
		String s = stringLists[0].get(0); // ClassCastException
	}

	public static void main(String[] args) {
		dangerous(List.of("There be dragons!"));
	}
}
