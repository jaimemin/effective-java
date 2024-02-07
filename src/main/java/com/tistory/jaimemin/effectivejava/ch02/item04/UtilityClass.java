package com.tistory.jaimemin.effectivejava.ch02.item04;

public class UtilityClass {

	/**
	 * 이 클래스는 인스턴스를 만들 수 없습니다.
	 */
	private UtilityClass() {
		throw new AssertionError(); // 무조건 에러다
	}

	public static void func() {
		System.out.println("func");
	}

	public static void main(String[] args) {
		UtilityClass.func();
		/**
		 * 문법적으로 잘 못된 코드는 아니지만 굉장히 불필요한 코드
		 */
		UtilityClass utilityClass = new UtilityClass();
		utilityClass.func();

	}
}
