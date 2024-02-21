package com.tistory.jaimemin.effectivejava.ch05.item32;

import java.util.ArrayList;
import java.util.List;

// 코드 32-3 제네릭 varargs 매개변수를 안전하게 사용하는 메서드 (195쪽)
public class FlattenWithVarargs {

	/**
	 * 자바 7부터 도입된 SafeVarargs: 가변인자 안전하게 쓰고 있다는 어노테이션
	 * @SuppressedWarnings를 쓰면 메서드 내 모든 비검사 경고를 제거 (더 넓은 범위)
	 * @SafeVarargs는 가변인자 관련 비검사 경고만 제거
	 *
	 * 제네릭 배열 내 먼가를 넣는 순간 타입 안전성 보장 못함
	 * 제네릭 배열을 절대 외부에 노출하면 안됨
	 */
	@SafeVarargs
	static <T> List<T> flatten(List<? extends T>... lists) {
		List<T> result = new ArrayList<>();

		for (List<? extends T> list : lists) {
			result.addAll(list);
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> flatList = flatten(
			List.of(1, 2), List.of(3, 4, 5), List.of(6, 7));
		System.out.println(flatList);
	}
}
