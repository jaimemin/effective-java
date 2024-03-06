package com.tistory.jaimemin.effectivejava.ch08.item49;

import java.util.Objects;

public class Example {

	private int index;

	private String name;

	/**
	 * Example 클래스 생성자
	 *
	 * @param index 인덱스 값 (0 이상의 정수여야 함)
	 * @param name  객체 이름 (null이 아니어야 함)
	 * @throws IllegalArgumentException 인덱스 값이 0 미만이거나 이름이 null인 경우
	 */
	public Example(int index, String name) {
		// 인덱스 값은 0 이상이어야 함
		if (index < 0) {
			throw new IllegalArgumentException("인덱스 값은 0 이상이어야 합니다.");
		}

		this.index = index;
		this.name = Objects.requireNonNull(name, "이름은 null이 아니어야 합니다.");
	}

	/**
	 * 인덱스 값을 설정하는 메서드
	 *
	 * @param newIndex 새로운 인덱스 값 (0 이상의 정수여야 함)
	 * @throws IllegalArgumentException 인덱스 값이 0 미만인 경우
	 */
	public void setIndex(int newIndex) {
		// 인덱스 값은 0 이상이어야 함
		if (newIndex < 0) {
			throw new IllegalArgumentException("인덱스 값은 0 이상이어야 합니다.");
		}

		this.index = newIndex;
	}

	/**
	 * 이름을 설정하는 메서드
	 *
	 * @param newName 새로운 이름 (null이 아니어야 함)
	 * @throws IllegalArgumentException 이름이 null인 경우
	 */
	public void setName(String newName) {
		// 객체 참조는 null이 아니어야 함
		this.name = Objects.requireNonNull(newName, "이름은 null이 아니어야 합니다.");
	}
}


