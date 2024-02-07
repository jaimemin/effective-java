package com.tistory.jaimemin.effectivejava.ch04.item23.hierarchy;

// 코드 23-2 태그 달린 클래스를 클래스 계층구조로 변환 (144쪽)
abstract class Figure {
	abstract double area();

	@Override
	public String toString() {
		return String.format("넓이: %f", area());
	}

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(2, 3);
		Square square = new Square(2);
		Circle circle = new Circle(2.2);

		System.out.println(String.format("rectangle %s", rectangle));
		System.out.println(String.format("square %s", square));
		System.out.println(String.format("circle %s", circle));
	}
}
