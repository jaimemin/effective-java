package com.tistory.jaimemin.effectivejava.ch02.item06;

import java.util.regex.Pattern;

// 값비싼 객체를 재사용해 성능을 개선한다. (32쪽)
public class RomanNumerals {

	private static final String ROMAN_NUMERAL = "MCMLXXVI";

	// 코드 6-1 성능을 훨씬 더 끌어올릴 수 있다!
	static boolean isRomanNumeralSlow(String s) {
		return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}

	// 코드 6-2 값비싼 객체를 재사용해 성능을 개선한다.
	/**
	 * 정규식 같은 경우 한 번 만들 때 만드는 비용이 좀 비쌈 (CPU 사용)
	 * 내부적으로 패턴을 컴파일하는 과정이 비싼 작업
	 * 자주 쓰는 패턴은 필드로 선언해서 사용하는 것을 추천
	 * <p>
	 * 문자열을 매칭할 때 쓰는 알고리즘이 "유한 상태 머신" 알고리즘을 쓰여서 그럼
	 */
	private static final Pattern ROMAN = Pattern.compile(
		"^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

	private static String getDuration(String format, long end, long start) {
		return String.format(format, end - start);
	}

	static boolean isRomanNumeralFast(String s) {
		return ROMAN.matcher(s).matches();
	}

	public static void main(String[] args) {
		boolean result = false;
		long start = System.nanoTime();

		for (int j = 0; j < 100; j++) {
			result = isRomanNumeralSlow(ROMAN_NUMERAL);
		}

		long end = System.nanoTime();

		System.out.println(getDuration("isRomanNumeralSlow 소요시간: %d", end, start));
		System.out.println("result: " + result);

		start = System.nanoTime();

		for (int i = 0; i < 100; i++) {
			result = isRomanNumeralFast(ROMAN_NUMERAL);
		}

		end = System.nanoTime();

		System.out.println(getDuration("isRomanNumeralFast 소요시간: %d", end, start));
		System.out.println("result: " + result);
	}

}
