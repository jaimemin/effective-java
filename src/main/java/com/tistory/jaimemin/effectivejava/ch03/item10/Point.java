package com.tistory.jaimemin.effectivejava.ch03.item10;

import java.util.ArrayList;
import java.util.List;

// 단순한 불변 2차원 정수 점(point) 클래스 (56쪽)
public class Point {

	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * lock 자체는 어떤 클래스가 가지고 있는 고유한 필드가 아니므로
	 * 핵심적인 필드가 아님
	 *
	 * primitive type이면 ==로 비교
	 * Double과 같은 부동소수점들은 compare() 메서드로 비교
	 * Objects.equals()는 null도 허용하므로 null 비교는 Objects.equals 사용
	 *
	 * 위 원칙을 다 지키며 직접 equals 구현하기 빡셈
	 * 따라서 웬만하면 직접 정의하지 말자
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) { // 객체의 동일성 (반사성)
			return true;
		}

		if (!(o instanceof Point)) { // 타입 비교
			return false;
		}

		Point p = (Point)o; // 타입 캐스팅

		return p.x == x && p.y == y; // "핵심적인 필드"들만 비교
	}

	/**
	 * 오버라이딩이 아닌 오버로딩
	 * 논리적 동치성 보장 X
	 *
	 * Object의 equals로 비교하는 꼴
	 */
	public boolean equals(Point p) {
		if (this == p) {
			return true;
		}

		return p.x == x && p.y == y;
	}

	public static void main(String[] args) {
		Point point = new Point(1, 2);
		List<Point> points = new ArrayList<>();
		points.add(point);
		System.out.println(points.contains(new Point(1, 2)));
	}

	/**
	 * 하위 클래스 equals는 고려하지 말자
	 */
	// 잘못된 코드 - 리스코프 치환 원칙 위배! (59쪽)
	//    @Override public boolean equals(Object o) {
	//        if (o == null || o.getClass() != getClass())
	//            return false;
	//        Point p = (Point) o;
	//        return p.x == x && p.y == y;
	//    }

	// 아이템 11 참조
	@Override
	public int hashCode() {
		return 31 * x + y;
	}
}
