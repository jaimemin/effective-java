package com.tistory.jaimemin.effectivejava.ch01.item03.enumtype;

/**
 * 열거 타입 방식의 싱글턴 - 바람직한 방법 (25쪽)
 *
 * Reflection 과 역직렬화에 안전한 방법
 * 테스트 또한 IElvis 를 상속하고 Mocking 하면 됨
 */
public enum Elvis {

	INSTANCE;

	public void leaveTheBuilding() {
		System.out.println("기다려 자기야, 지금 나갈께!");
	}

	// 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
	public static void main(String[] args) {
		Elvis elvis = Elvis.INSTANCE;
		elvis.leaveTheBuilding();
	}
}
