package com.tistory.jaimemin.effectivejava.ch04.item24.localclass;

public class MyClass {

	private int number = 10;

	void doSomething() {
		/**
		 * 실용적이지 않아서 잘 쓰이지 않음
		 * 메서드가 너무 길어짐
		 */
		class LocalClass {
			private void printNumber() {
				System.out.println(number);
			}
		}

		LocalClass localClass = new LocalClass();
		localClass.printNumber();
	}

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		myClass.doSomething();
	}
}
