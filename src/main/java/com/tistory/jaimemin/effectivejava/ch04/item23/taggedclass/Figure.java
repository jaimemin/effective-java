package com.tistory.jaimemin.effectivejava.ch04.item23.taggedclass;

/**
 * 가독성 안 좋고 코드를 디버깅하기 어려움
 * 깔끔하게 정의되어있는 것에 비해 쓸데없는 필드들을 가지고 있으므로 메모리를 더 잡아먹음
 * 인스턴스 타입만으로 어떤 태그인지 알 수 없음
 * -> 상속을 통해 해결 가능
 *
 * if문과 switch문이 많다면 단일 클래스로 너무 많은 것을 표현하려고 하지 않았는가를 의심해볼법 함
 *
 * 도형이 추가될수록 점점 더 복잡해질 클래스
 */
// 코드 23-1 태그 달린 클래스 - 클래스 계층구조보다 훨씬 나쁘다! (142-143쪽)
class Figure {

    enum Shape {RECTANGLE, CIRCLE, SQUARE}

    ;

    // 태그 필드 - 현재 모양을 나타낸다.
    final Shape shape;

    // 다음 필드들은 모양이 사각형(RECTANGLE)일 때만 쓰인다.
    double length;

    double width;

    // 다음 필드는 모양이 원(CIRCLE)일 때만 쓰인다.
    double radius;

    // 원용 생성자
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형용 생성자
    Figure(double length, double width) {
        if (this.length == this.width) {
            shape = Shape.SQUARE;
        } else {
            shape = Shape.RECTANGLE;
        }

        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
            case SQUARE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
