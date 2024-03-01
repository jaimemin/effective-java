package com.tistory.jaimemin.effectivejava.ch07.item43.generic;

public class Example {

	public static void main(String[] args) {
		// G1 인터페이스를 메서드 참조로 구현
		G1 g1 = Example::func;
		// G1 g1 = () -> {
		// 	return func();
		// };
	}

	public static Object func() throws RuntimeException {
		return new Object();
	}
}
