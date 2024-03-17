package com.tistory.jaimemin.effectivejava.ch09.item61;

public class Example {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Long sum = 0L;

		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}

		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println(String.format("혼용해서 사용하는 경우 실행시간: %d", (end - start)));

		start = System.currentTimeMillis();
		long sum2 = 0L;

		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum2 += i;
		}

		end = System.currentTimeMillis();
		System.out.println(sum2);
		System.out.println(String.format("기본 타입만 사용했을 경우 실행시간: %d", (end - start)));
	}
}
