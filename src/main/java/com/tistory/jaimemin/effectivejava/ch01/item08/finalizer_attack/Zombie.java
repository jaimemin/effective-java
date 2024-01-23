package com.tistory.jaimemin.effectivejava.ch01.item08.finalizer_attack;

public class Zombie {

	protected Integer value = 0;

	public Zombie(int value) {
		if (value <= 0) {
			throw new IllegalArgumentException("Zombie value must be positive");
		}

		this.value = value;
	}
}
