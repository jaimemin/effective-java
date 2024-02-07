package com.tistory.jaimemin.effectivejava.ch03.item12.shape;

class Rectangle extends Shape {

	private double length;

	private double width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	double calculateArea() {
		return length * width;
	}

	@Override
	String getShapeDetails() {
		return "사각형 길이: " + length + ", 너비: " + width;
	}
}