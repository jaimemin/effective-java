package com.tistory.jaimemin.effectivejava.ch01.item08.cleaner_as_a_safety_net;

// cleaner 안전망을 갖춘 자원을 제대로 활용하지 못하는 클라이언트 (45쪽)
public class Teenager {

	/**
	 * GC가 호출될 수도 있고 안될 수도 있음
	 */
	public static void main(String[] args) {
		new Room(99);
		System.out.println("Peace out");

		// 다음 줄의 주석을 해제한 후 동작을 다시 확인해보자.
		// 단, 가비지 컬렉러를 강제로 호출하는 이런 방식에 의존해서는 절대 안 된다!
		System.gc();
	}
}
