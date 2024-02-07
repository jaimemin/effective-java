package com.tistory.jaimemin.effectivejava.ch04.item21;

public class SubClass extends SuperClass implements MarkerInterface {

	/**
	 * 메서드를 찾는 규칙
	 * 항상 클래스가 인터페이스를 이기게 되어있음
	 * 따라서 default 메서드가 아닌 SuperClass의 private 메서드인 hello를 호출하려고 함
	 */
	public static void main(String[] args) {
		SubClass subClass = new SubClass();
		subClass.hello(); // Runtime Exception
	}

}
