package com.tistory.jaimemin.effectivejava.ch02.item13.inheritance;

public class Rectangle extends Shape {

	private int width, height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle rectangle = new Rectangle(5, 4);
		Rectangle copy = (Rectangle)rectangle.clone();

		System.out.println(copy.getArea());
	}

	@Override
	public int getArea() {
		return width * height;
	}
}
