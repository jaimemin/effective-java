package com.tistory.jaimemin.effectivejava.ch04.item16;

public class TopLevelPoint {

	private static class Point {

		public double x;

		public double y;
	}

	public Point getPoint() {
		Point point = new Point();
		point.x = 30;
		point.y = 40;

		return point;
	}
}
