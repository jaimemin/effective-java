package com.tistory.jaimemin.effectivejava.ch04.item16.field;

public class Point {

	public double x;

	public double y;

	public static void main(String[] args) {
		Point point = new Point();
		point.x = 30;
		point.y = 40;

		System.out.println(String.format("x = %f, y = %f", point.x, point.y));
	}
}
