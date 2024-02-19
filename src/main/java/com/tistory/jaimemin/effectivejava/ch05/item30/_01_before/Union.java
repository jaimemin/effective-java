package com.tistory.jaimemin.effectivejava.ch05.item30._01_before;

import java.util.HashSet;
import java.util.Set;

// 제네릭 union 메서드와 테스트 프로그램 (177쪽)
public class Union {

	// 코드 30-2 제네릭 메서드 (177쪽)

	/**
	 * 매개변수화 타입을 매개변수로 받는 제네릭 메서드
	 * Collections를 보면 모든 유틸리성 클래스가 제네릭으로 만들어진 것을 확인할 수 있음
	 */
	public static <E> Set<E> union(Set s1, Set s2) {
		Set result = new HashSet(s1);
		result.addAll(s2);

		return result;
	}

	// 코드 30-3 제네릭 메서드를 활용하는 간단한 프로그램 (177쪽)
	public static void main(String[] args) {
		Set<String> guys = Set.of("톰", "딕", "해리");
		// Set<String> stooges = Set.of("래리", "모에", "컬리");
		Set<Integer> stooges = Set.of(1, 2, 3);
		Set<String> all = union(guys, stooges); // 그냥 Set일 경우 합치는 것까지는 문제없음

		/**
		 * Set<String>끼리 합치는 것을 예상
		 */
		for (Object o : all) {
			System.out.println((String)o); // 런타임에 형변환할 때 ClassCastException 발생 가능
		}
	}
}
