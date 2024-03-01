package com.tistory.jaimemin.effectivejava.ch07.item42;

public class ThisReference {

	public static void main(String[] args) {
		ThisReference thisReference = new ThisReference();
		// 람다의 this
		thisReference.lambdaRun();
		// 익명 클래스의 this
		thisReference.anonymousClassRun();
	}

	public void lambdaRun() {
		Runnable runnable = () -> System.out.println("람다의 this: " + this);
		runnable.run();
	}

	public void anonymousClassRun() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("익명 클래스의 this: " + this);
			}

			@Override
			public String toString() {
				return "익명 클래스";
			}
		};
		runnable.run();
	}
}
