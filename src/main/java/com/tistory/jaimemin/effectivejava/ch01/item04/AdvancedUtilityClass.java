package com.tistory.jaimemin.effectivejava.ch01.item04;

/**
 * 추상 클래스여도 서브 클래스 통해 생성자 호출 가능
 */
public class AdvancedUtilityClass extends AbstractUtilityClass {

	public static void main(String[] args) {
		AdvancedUtilityClass utilityClass = new AdvancedUtilityClass();
		utilityClass.func();
	}
}
