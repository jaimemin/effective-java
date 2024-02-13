package com.tistory.jaimemin.effectivejava.ch05.item27.suppress;

import java.util.Arrays;

public class ListExample {

	private int size;

	Object[] elements;

	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			/**
			 * 이 애노테이션을 왜 여기서 선언했는지 설명 필요 (타입 안전한데 비검사 경고 제거할 방법이 없어 붙였다~)..
			 *
			 * 가능한 한 좁은 범위에 붙이는 것을 권장
			 * 한 줄로 return하고 메서드에 붙일 수 있지만 메서드 내 다른 suppress warning 발생해도 알 수 없음
			 */
			@SuppressWarnings("unchecked") // return문에 붙일 수 없기 때문에 변수로 선언 후 어노테이션
			T[] result = (T[])Arrays.copyOf(elements, size, a.getClass());

			return result;
		}

		System.arraycopy(elements, 0, a, 0, size);

		if (a.length > size) {
			a[size] = null;
		}

		return a;
	}

}
