package com.tistory.jaimemin.effectivejava.ch07.item48;

import java.util.ArrayList;
import java.util.List;

public class IncorrectStreamExample {

	private static int MAX = 100;

	private static int sum = 0;

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();

		for (int i = 1; i <= MAX; i++) {
			numbers.add(i);
		}

		// 안전 실패가 발생할 수 있는 잘못된 병렬 스트림 사용 예제
		numbers.parallelStream()
			.forEach(num -> {
				// 안전 실패: 여러 스레드에서 동시에 상태를 변경
				sum += num;
			});

		System.out.println(String.format("예상 결과: %d", (MAX * (MAX + 1)) / 2));
		System.out.println(String.format("실제 결과: %d", sum));
	}
}
