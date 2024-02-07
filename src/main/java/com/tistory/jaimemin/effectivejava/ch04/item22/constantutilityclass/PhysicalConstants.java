package com.tistory.jaimemin.effectivejava.ch04.item22.constantutilityclass;

/**
 * 여러 클래스에서 사용하는 상수라면
 * 상수 유틸리티 클래스 정의하여 인스턴스화 못하도록
 *
 * 인터페이스는 구현하는 것을 막을 수 없지만 클래스는 상속 막을 수 있고 인스턴스화 막을 수 있음
 */
// 코드 22-2 상수 유틸리티 클래스 (140쪽)
public class PhysicalConstants {

	private PhysicalConstants() {
	}  // 인스턴스화 방지

	// 아보가드로 수 (1/몰)
	public static final double AVOGADROS_NUMBER = 6.022_140_857e23;

	// 볼츠만 상수 (J/K)
	public static final double BOLTZMANN_CONST = 1.380_648_52e-23;

	// 전자 질량 (kg)
	public static final double ELECTRON_MASS = 9.109_383_56e-31;
}
