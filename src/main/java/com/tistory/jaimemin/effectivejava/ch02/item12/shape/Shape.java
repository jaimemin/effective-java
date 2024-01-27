package com.tistory.jaimemin.effectivejava.ch02.item12.shape;

abstract class Shape {
	// 각 도형의 면적을 계산하는 추상 메서드
	abstract double calculateArea();

	// 도형 정보를 문자열로 반환하는 메서드
	@Override
	public String toString() {
		return "도형 정보: " + getShapeDetails() + ", 면적: " + calculateArea();
	}

	// 각 도형의 세부 정보를 얻는 추상 메서드
	abstract String getShapeDetails();

	public static void main(String[] args) {
		// 추상 클래스를 사용하는 예제
		Shape circle = new Circle(5.0);
		Shape rectangle = new Rectangle(4.0, 6.0);

		// 각 도형의 정보를 출력
		System.out.println(circle.toString());
		System.out.println(rectangle.toString());
	}
}
