package com.tistory.jaimemin.effectivejava.ch05.item30.recursive_type_bound;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

// 재귀적 타입 한정을 이용해 상호 비교할 수 있음을 표현 (179쪽)
public class RecursiveTypeBound {

	public static <E extends Comparable<E>> E max(Collection<E> c) {
		if (c.isEmpty()) {
			throw new IllegalArgumentException("컬렉션이 비어 있습니다.");
		}

		E result = null;

		for (E e : c) {
			if (result == null || e.compareTo(result) > 0) {
				result = Objects.requireNonNull(e);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> argList = List.of(1, 3, 5, 7, 10, 8, 100, 2);
		System.out.println(max(argList));
	}
}
