package com.tistory.jaimemin.effectivejava.ch04.item24.adapter;

// Rectangle 인터페이스에 맞게 동작하도록 Square 클래스를 어댑트하는 어댑터 클래스
class SquareAdapter implements Rectangle {

	private Square square;

	public SquareAdapter(Square square) {
		this.square = square;
	}

	@Override
	public void drawRectangle() {
		// Square 클래스의 drawSquare 메서드를 Rectangle 인터페이스의 drawRectangle에 맞게 호출
		square.drawSquare();
	}

	public static void main(String[] args) {
		// 기존의 Square 클래스 인스턴스 생성
		Square square = new Square();
		// 어댑터를 통해 Square를 Rectangle로 사용
		Rectangle squareAdapter = new SquareAdapter(square);
		// 클라이언트 코드에서는 Rectangle 인터페이스의 메서드를 호출
		squareAdapter.drawRectangle();
	}
}
