package com.tistory.jaimemin.effectivejava.ch11.item82;

public class Example {

	private final Object lock = new Object();

	public void func() {
		synchronized (lock) {
			// ...
		}
	}
}
