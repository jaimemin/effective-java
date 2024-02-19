package com.tistory.jaimemin.effectivejava.ch05.item30._01_before;

import java.util.function.Function;

// 제네릭 싱글턴 팩터리 패턴 (178쪽)
public class GenericSingletonFactory {

	/**
	 * 타입이 다르기 때문에 타입별로 function 만들어야함
	 * 제네릭은 소거 방식이기 때문에 단일 함수 정의로 모든 타입에 대한 항등함수를 커버 가능
	 */
	public static Function<String, String> stringIdentityFunction() {
		return (t) -> t;
	}

	public static Function<Number, Number> integerIdentityFunction() {
		return (t) -> t;
	}

	// 코드 30-5 제네릭 싱글턴을 사용하는 예 (178쪽)
	public static void main(String[] args) {
		String[] strings = {"삼베", "대마", "나일론"};
		Function<String, String> sameString = stringIdentityFunction();

		for (String s : strings) {
			System.out.println(sameString.apply(s));
		}

		Number[] numbers = {1, 2.0, 3L};
		Function<Number, Number> sameNumber = integerIdentityFunction();

		for (Number n : numbers) {
			System.out.println(sameNumber.apply(n));
		}
	}
}
