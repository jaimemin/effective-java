package com.tistory.jaimemin.effectivejava.ch02.item06;

import java.util.regex.Pattern;

/**
 * character 가 하나일 때는 그냥 split 으로 사용하는 것이 빠름 (fast path)
 * 이외에는 cache 하는 것이 유리
 * <p>
 * match
 * split
 * replaceFirst
 * replaceAll
 */
public class RegularExpression {

	private static final Pattern SPLIT_PATTERN = Pattern.compile(",");

	public static void main(String[] args) {
		long start = System.nanoTime();

		for (int j = 0; j < 10000; j++) {
			String name = "jaimemin,gudetama";
			name.split(",");
			// SPLIT_PATTERN.split(name);
		}

		System.out.println(System.nanoTime() - start);
	}
}
