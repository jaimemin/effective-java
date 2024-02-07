package com.tistory.jaimemin.effectivejava.ch03.item12.shape;

class Circle extends Shape {

	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double calculateArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	String getShapeDetails() {
		return "원 반지름: " + radius;
	}
}
