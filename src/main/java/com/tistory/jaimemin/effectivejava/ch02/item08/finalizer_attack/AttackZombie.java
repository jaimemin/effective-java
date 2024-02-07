package com.tistory.jaimemin.effectivejava.ch02.item08.finalizer_attack;

public class AttackZombie extends Zombie {

	static Zombie zombie;

	public AttackZombie(int value) {
		super(value);
	}

	@Override
	protected void finalize() throws Throwable {
		zombie = this;
	}

	public static void main(String[] args) throws InterruptedException {
		try {
			new AttackZombie(-1);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.gc();
		System.runFinalization();
		Thread.sleep(1000);

		if (zombie != null) {
			System.out.println("Zombie object attack " + zombie.value + " success!");
		}
	}
}
