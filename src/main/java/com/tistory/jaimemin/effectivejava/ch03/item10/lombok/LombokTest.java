package com.tistory.jaimemin.effectivejava.ch03.item10.lombok;

public class LombokTest {

	public static void main(String[] args) {
		Point point = new Point(1, 2);
		System.out.println(point.equals(new Point(1, 2)));
	}
}