package com.tistory.jaimemin.effectivejava.ch01.item07.reference;

import java.lang.ref.WeakReference;

/**
 * Soft, Weak, Phantom 레퍼런스를 사용하기 보다는
 * 명시적으로 Map 혹은 List에서 지워버리자
 * 정확히 레퍼런스가 자원 정리하는 시점을 모르기 때문에 확실하게 지워버리는 것이 좋음
 */
public class WeakReferenceExample {

	public static void main(String[] args) throws InterruptedException {
		Object strong = new Object();
		WeakReference<Object> weak = new WeakReference<>(strong);
		strong = null;

		System.gc();
		Thread.sleep(3000L);

		/**
		 * 거의 없어집니다.
		 * 왜냐면 약하니까(?)...
		 */
		System.out.println(weak.get());
	}
}
