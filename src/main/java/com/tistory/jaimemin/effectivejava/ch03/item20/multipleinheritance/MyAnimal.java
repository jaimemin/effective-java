package com.tistory.jaimemin.effectivejava.ch03.item20.multipleinheritance;

public class MyAnimal extends AbstractAnimal implements Swimmable {

	private MySwimmable myFlyable = new MySwimmable();

	@Override
	protected String sound() {
		return "으르렁";
	}

	@Override
	protected String name() {
		return "유메";
	}

	public static void main(String[] args) {
		MyAnimal myAnimal = new MyAnimal();
		System.out.println(myAnimal.sound());
		System.out.println(myAnimal.name());
		myAnimal.swim();
	}

	/**
	 * 위임을 하면 다중 상속을 시뮬레이트할 수 있음
	 */
	@Override
	public void swim() {
		this.myFlyable.swim();
	}

	private class MySwimmable extends AbstractSwimmable {
		@Override
		public void swim() {
			System.out.println("MySwimmable swim");
		}
	}
}
