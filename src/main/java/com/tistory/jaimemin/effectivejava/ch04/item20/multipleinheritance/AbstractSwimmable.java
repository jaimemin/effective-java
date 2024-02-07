package com.tistory.jaimemin.effectivejava.ch04.item20.multipleinheritance;

public class AbstractSwimmable implements Swimmable {

	@Override
	public void swim() {
		System.out.println("AbstractSwimmable swim");
	}
}
