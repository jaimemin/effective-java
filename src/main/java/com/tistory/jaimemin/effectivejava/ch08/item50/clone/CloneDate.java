package com.tistory.jaimemin.effectivejava.ch08.item50.clone;

import java.util.Date;

import com.tistory.jaimemin.effectivejava.ch08.item50.Period;

public class CloneDate extends Date {

	public CloneDate() {
		super();
	}

	@Override
	public Object clone() {
		System.out.println("악의적인 작업 수행해서 년도를 1978로 바꿈");
		this.setYear(78);

		return super.clone();
	}

	public static void main(String[] args) {
		Date start = new Date(70);
		CloneDate end = new CloneDate(); // 2024년을 예상
		Period period = new Period(start, end);

		System.out.println(period);
	}
}
