package com.tistory.jaimemin.effectivejava.ch04.item24.memberclass;

public class OuterClass {

	private int number = 10;

	void printNumber() {
		InnerClass innerClass = new InnerClass();
	}

	/**
	 * Outer Instance 참조가 생김 (암묵적으로 reference 생김)
	 *
	 * 바깥 클래스에 대한 참조가 없다면 즉 독립적이라면 static하게 만들어주는 것을 권장
	 * 불필요하게 OuterClass를 생성해야 함
	 */
	private class InnerClass {
		void doSomething() {
			System.out.println(number);
			OuterClass.this.printNumber();
		}
	}

	public static void main(String[] args) {
		InnerClass innerClass = new OuterClass().new InnerClass(); // 이런식으로
		innerClass.doSomething();
	}

}
