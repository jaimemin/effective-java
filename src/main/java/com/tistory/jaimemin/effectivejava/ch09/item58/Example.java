package com.tistory.jaimemin.effectivejava.ch09.item58;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		for (Iterator<Integer> i = list.iterator(); i.hasNext(); ) {
			Integer num = i.next();
			// num을 이용한 비즈니스 로직
		}

		for (int i = 0; i < list.size(); i++) {
			// list[i]를 이용한 비즈니스 로직
		}

		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);

		Iterator<Integer> iterator = numbers.iterator();

		while (iterator.hasNext()) {
			Integer number = iterator.next();

			if (number % 2 == 0) {
				iterator.remove(); // 반복자의 remove 메서드를 호출하여 안전하게 제거
			}
		}

		System.out.println(numbers);
	}
}
