package com.tistory.jaimemin.effectivejava.ch04.item24.staticmemberclass;

public class OuterClass {

	private static int number = 10;

	/**
	 * static 멤버 클래스
	 * 정의되어 있는 scope이 클래스 범위
	 *
	 * 바깥 클래스에 있는 정적 필드 접근 가능
	 * 바깥 클래스와 독립적이기 때문에 바깥 클래스 인스턴스가 필요하지 않음
	 *
	 * 쓰임새: OuterClass 거쳐서 함께 쓰일 때 유용할 때
	 * ex) Calculator enum 같은 경우 PLUS, MINUS, DIVIDE, MULTIPLY 등등
	 */
	static private class InnerClass {
		void doSomething() {
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		InnerClass innerClass = new InnerClass();
		innerClass.doSomething();

	}
}
