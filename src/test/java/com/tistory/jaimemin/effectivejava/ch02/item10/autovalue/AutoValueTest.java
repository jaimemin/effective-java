package com.tistory.jaimemin.effectivejava.ch02.item10.autovalue;

public class AutoValueTest {

	public static void main(String[] args) {
		Point point = Point.create(1, 2);
		System.out.println(point.equals(Point.create(1, 2)));
	}
}
