package com.tistory.jaimemin.effectivejava.ch05.item31;

import java.util.Arrays;
import java.util.List;

// 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드 (189쪽)
public class Swap {

	/**
	 * ?를 쓰면
	 * 장점: 간단해짐
	 * 단점: 꺼내는 것은 가능하지만 ? 타입이 먼지 모르니까 null 밖에 넣을 수 없음
	 */
	public static void swap(List<?> list, int i, int j) {
		swapHelper(list, i, j);
	}

	// public static <E> void swap(List<E> list, int i, int j) {
	// 	list.set(i, list.set(j, list.get(i)));
	// }

	/**
	 * 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드
	 * 굳이 helper성 메서드를 쓰면서 단독으로 ?를 써야할지는 의문
	 */
	private static <E> void swapHelper(List<E> list, int i, int j) {
		list.set(i, list.set(j, list.get(i)));
	}

	public static void main(String[] args) {
		// 첫 번째와 마지막 인수를 스왑한 후 결과 리스트를 출력한다.
		List<String> argList = Arrays.asList(args);
		swap(argList, 0, argList.size() - 1);
		System.out.println(argList);
	}
}
