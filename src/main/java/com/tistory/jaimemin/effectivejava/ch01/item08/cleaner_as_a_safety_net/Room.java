package com.tistory.jaimemin.effectivejava.ch01.item08.cleaner_as_a_safety_net;

import java.lang.ref.Cleaner;

// 코드 8-1 cleaner를 안전망으로 활용하는 AutoCloseable 클래스 (44쪽)
public class Room implements AutoCloseable {
	private static final Cleaner cleaner = Cleaner.create();

	// 청소가 필요한 자원. 절대 Room을 참조해서는 안 된다!
	private static class State implements Runnable {
		int numJunkPiles; // Number of junk piles in this room

		State(int numJunkPiles) {
			this.numJunkPiles = numJunkPiles;
		}

		// close 메서드나 cleaner가 호출한다.
		@Override
		public void run() {
			System.out.println("Cleaning room");
			numJunkPiles = 0;
		}
	}

	// 방의 상태. cleanable과 공유한다.
	private final State state;

	// cleanable 객체. 수거 대상이 되면 방을 청소한다.
	private final Cleaner.Cleanable cleanable;

	/**
	 * 클리너 등록은 Teenager 용
	 * try-with-resource를 사용하지 않는 사용자를 위해 "안전망"으로 추천
	 * 메인으로는 X
	 */
	public Room(int numJunkPiles) {
		state = new State(numJunkPiles);
		cleanable = cleaner.register(this, state);
	}

	/**
	 * try-with-resource에서 호출되는 close()
	 */
	@Override
	public void close() {
		cleanable.clean();
	}
}
