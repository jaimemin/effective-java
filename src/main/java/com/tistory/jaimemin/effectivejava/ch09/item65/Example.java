package com.tistory.jaimemin.effectivejava.ch09.item65;

public class Example {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		MyClass instance = new MyClass();
		MyClass instance2 = new MyClass("jaimemin", 29);

		System.out.print("디폴트 생성자로 생성한 인스턴스: ");
		instance.displayInfo();
		System.out.print("AllArgsConstructor로 생성한 인스턴스: ");
		instance2.displayInfo();

		System.out.println("디폴트로 생성한 생성자 setter를 Relection으로 접근하여 값 설정");
		instance.setName("gudetama");
		instance2.setAge(29);

		System.out.print("디폴트 생성자로 생성한 인스턴스: ");
		instance.displayInfo();
		long end = System.currentTimeMillis();
		System.out.println(String.format("실행시간: %d", (end - start)));
	}
}
