package com.tistory.jaimemin.effectivejava.ch04.item24.anonymousclass;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// 코드 20-1 골격 구현을 사용해 완성한 구체 클래스 (133쪽)
public class IntArrays {
	static List<Integer> intArrayAsList(int[] a) {
		Objects.requireNonNull(a);

		/**
		 * 다이아몬드 연산자를 이렇게 사용하는 건 자바 9부터 가능하다.
		 * 더 낮은 버전을 사용한다면 <Integer>로 수정하자.
		 *
		 * Java 8부터는 익명 클래스보다 람다 혹은 메서드 레퍼런스가 더 많이 사용되는 추세
		 *
		 * 정의함과 동시에 인스턴스 생성
		 */
		return new AbstractList<>() {
			@Override
			public Integer get(int i) {
				return a[i];  // 오토박싱(아이템 6)
			}

			@Override
			public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val;     // 오토언박싱
				return oldVal;  // 오토박싱
			}

			@Override
			public int size() {
				return a.length;
			}
		};
	}

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++)
			a[i] = i;

		List<Integer> list = intArrayAsList(a);
		Collections.shuffle(list);
		System.out.println(list);
	}
}
