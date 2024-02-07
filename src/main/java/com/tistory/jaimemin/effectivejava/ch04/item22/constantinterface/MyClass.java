package com.tistory.jaimemin.effectivejava.ch04.item22.constantinterface;

/**
 * 인터페이스 원래 의도: 타입을 정의
 * MyClass는 PhysicalConstants 타입인가?
 * 기술적으로는 정의할 수 있지만 설계적으로는 적합하지 않음
 * 상수는 클래스 내부에 사용되기 위해 정의되었지만 인터페이스를 통해 공개되었기 때문에 캡슐화 깨짐
 *
 * 해당 클래스에서만 상수를 사용할 경우 해당 클래스로 옮기고 private static final스
 */
public class MyClass implements PhysicalConstants {

	public static void main(String[] args) {
		System.out.println(BOLTZMANN_CONSTANT);
	}

}
