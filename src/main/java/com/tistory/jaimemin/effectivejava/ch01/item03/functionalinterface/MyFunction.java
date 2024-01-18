package com.tistory.jaimemin.effectivejava.ch01.item03.functionalinterface;

/**
 * method 선언은 오직 하나 (어노테이션 없어도 @FunctionalInterface 라고 간주)
 * static 예외
 */
@FunctionalInterface
public interface MyFunction {

	String valueOf(Integer integer);

	static String hello() {
		return "hello";
	}
}