package com.tistory.jaimemin.effectivejava.ch05.item31.example;

public class IntegerBox extends Box<Integer> {

	private final Integer ball;

	public IntegerBox(int value, Integer ball) {
		super(value);
		this.ball = ball;
	}

	@Override
	public String toString() {
		return "IntegerBox{" +
			"ball='" + ball + '\'' +
			", value=" + value +
			'}';
	}
}
