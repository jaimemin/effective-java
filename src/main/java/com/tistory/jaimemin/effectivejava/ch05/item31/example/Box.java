package com.tistory.jaimemin.effectivejava.ch05.item31.example;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

	protected T value;

	public Box(T value) {
		this.value = value;
	}

	public void change(T value) {
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Box anotherBox) {
		return this.value.compareTo((T)anotherBox.value);
	}

	@Override
	public String toString() {
		return "Box{" +
			"value=" + value +
			'}';
	}
}
