package com.tistory.jaimemin.effectivejava.ch03.item16.method;

// 코드 16-2 접근자와 변경자(mutator) 메서드를 활용해 데이터를 캡슐화한다. (102쪽)
public class Point {

	private double x;

	private double y;

	public Point() {
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		// 부가 작업
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		// 부가 작업
		if (x <= 0.0) {
			throw new AssertionError();
		}

		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
}
