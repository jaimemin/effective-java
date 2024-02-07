package com.tistory.jaimemin.effectivejava.ch02.item07.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {

	public static void main(String[] args) throws InterruptedException {
		Object strong = new Object();
		/**
		 * Strong Reference -> Object
		 * Soft Reference -> Object
		 *
		 * 더 이상 Strong Reference가 없고 Soft Reference만 남았을 때
		 * 메모리가 필요한 상황에서만!! GC가 돌 때 회수됨
		 */
		SoftReference<Object> soft = new SoftReference<>(strong);
		strong = null;

		System.gc();
		Thread.sleep(3000L);

		/**
		 * 거의 안 없어집니다.
		 * 왜냐면 메모리가 충분해서.. 굳이 제거할 필요가 없으니까요.
		 */
		System.out.println(soft.get());
	}
}
