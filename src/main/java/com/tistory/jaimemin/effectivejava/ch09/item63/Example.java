package com.tistory.jaimemin.effectivejava.ch09.item63;

public class Example {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String result = "";

		for (int i = 0; i < 10000; i++) {
			result += String.valueOf(i);
		}

		System.out.println(result);
		long end = System.currentTimeMillis();
		System.out.println(String.format("+ 연산자를 통해 문자열 합치는 실행시간: %d", (end - start)));

		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10000; i++) {
			sb.append(String.valueOf(i));
		}

		System.out.println(sb.toString());
		end = System.currentTimeMillis();
		System.out.println(String.format("StringBuilder를 통해 문자열 합치는 실행시간: %d", (end - start)));
	}
}
