package com.tistory.jaimemin.effectivejava.ch02.item06;

public class Strings {

	public static void main(String[] args) {
		String hello = "hello";

		/**
		 * 이 방법은 권장 X
		 * JVM 은 내부적으로 문자열을 pool 에서 캐싱
		 * 일종의 해시맵에 한번 만들어 놓은 문자열을 저장해놓고 어떤 곳에서 동일한 문자열을 참조하려고 하면 pool 에서 재사용
		 * new 를 통해 새로 생성할 경우 동일하더라도 불필요하게 재생성
		 *
		 * 동잃란 문자열임에도 불구하고 메모리를 잡아먹는 것이 가장 큰 문제
		 */
		String hello2 = new String("hello");
		String hello3 = "hello";

		System.out.println(hello == hello2);
		System.out.println(hello.equals(hello2)); // 내용을 비교할 때는 equals (혹시나 인스턴스가 다른 경우 대비)
		System.out.println(hello == hello3);
		System.out.println(hello.equals(hello3));
	}
}
