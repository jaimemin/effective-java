package com.tistory.jaimemin.effectivejava.ch09.item62.enumerate;

// 열거 타입(enum) 예제
public enum Day {
	MONDAY("월요일"),
	TUESDAY("화요일"),
	WEDNESDAY("수요일"),
	// 나머지 요일들도 동일하게 정의
	;

	private final String value;

	// 생성자를 이용하여 문자열 값을 할당
	Day(String value) {
		this.value = value;
	}

	// 문자열 값을 반환하는 메서드
	public String getValue() {
		return value;
	}
}

