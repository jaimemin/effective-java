package com.tistory.jaimemin.effectivejava.ch07.item42;

public class Example {

	public static void main(String[] args) {
		// 익명 클래스 사용
		MyAbstractClass anonymousClassInstance = new MyAbstractClass() {
			@Override
			void myAbstractMethod() {
				System.out.println("Abstract method implemented using anonymous class");
			}
		};
		anonymousClassInstance.myAbstractMethod();

		// 람다 표현식 사용 - 오류 발생!
		// 추상 클래스는 람다 표현식으로 대체할 수 없음
		// MyAbstractClass lambdaInstance = () -> System.out.println("Abstract method implemented using lambda");
	}
}
