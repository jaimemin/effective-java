package com.tistory.jaimemin.effectivejava.ch05.item31;

import java.util.ArrayList;
import java.util.List;

import com.tistory.jaimemin.effectivejava.ch05.item31.example.IntegerBox;

// 와일드카드 타입을 사용해 재귀적 타입 한정을 다듬었다. (187쪽)
public class RecursiveTypeBound {

	/**
	 * Comparable은 무조건 꺼내서 비교하는 역할: consumer
	 * IntegerBox는 Comparable을 직접 구현하지 않았지만
	 * Comparable을 구현한 Box를 상속받았음
	 * -> E extends Comparable<? super E>
	 */
	public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException("빈 리스트");
		}

		E result = null;

		for (E e : list) {
			if (result == null || e.compareTo(result) > 0)
				result = e;
		}

		return result;
	}

	public static void main(String[] args) {
		List<IntegerBox> list = new ArrayList<>();
		list.add(new IntegerBox(10, 1));
		list.add(new IntegerBox(2, 1));

		System.out.println(max(list));
	}
}
