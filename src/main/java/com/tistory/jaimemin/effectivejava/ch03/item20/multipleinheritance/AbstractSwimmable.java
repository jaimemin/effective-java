package com.tistory.jaimemin.effectivejava.ch03.item20.multipleinheritance;

public class AbstractSwimmable implements Swimmable {

	@Override
	public void swim() {
		System.out.println("AbstractSwimmable swim");
	}
}
