package com.tistory.jaimemin.effectivejava.ch02.item08.outerclass;

import java.lang.reflect.Field;

public class LambdaExample {

	private int value = 10;

	/**
	 * 작업 처리하는 것을 이런식으로 정의하면 정리해야할 인스턴스 참조가 생기므로 지양
	 * 항상 그런 것은 아님
	 * 1. 멤버변수 value가 static이 아니고 람다에서 해당 변수를 참고할 경우
	 * 2. 멤버변수 value가 static일 경우 안 생김
	 */
	private Runnable instanceLambda = () -> {
		System.out.println(value);
	};

	public static void main(String[] args) {
		LambdaExample example = new LambdaExample();
		Field[] declaredFields = example.instanceLambda.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println("field type: " + field.getType());
			System.out.println("field name: " + field.getName());
		}
	}

}
