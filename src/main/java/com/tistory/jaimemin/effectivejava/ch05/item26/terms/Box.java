package com.tistory.jaimemin.effectivejava.ch05.item26.terms;

/**
 * 제네릭 클래스
 *
 */
public class Box<E> {

	private E item;

	private void add(E e) {
		this.item = e;
	}

	private E get() {
		return this.item;
	}

	public static void main(String[] args) {
		/**
		 * Integer는 실제 타입 매개변수
		 * Box<Integer>는 한정적 타입 매개변수
		 * ?는 비한정적 와일드 타입 (super 혹은 extends 없으면) 사실상 ? extends Object
		 * ? extends Annotation은 한정적 와일드 타입
		 */
		Box<Integer> box = new Box<>();
		box.add(10);
		System.out.println(box.get() * 100);

		printBox(box);
	}

	private static void printBox(Box<?> box) {
		System.out.println(box.get());
	}

}
