package com.tistory.jaimemin.effectivejava.ch02.item10.composition;

import java.util.Objects;

import com.tistory.jaimemin.effectivejava.ch02.item10.Color;
import com.tistory.jaimemin.effectivejava.ch02.item10.Point;

/**
 * 필드를 추가하고 싶다면 상속을 사용하지 말고 composition 권장
 */
// 코드 10-5 equals 규약을 지키면서 값 추가하기 (60쪽)
public class ColorPoint {

	private final Point point;

	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		point = new Point(x, y);
		this.color = Objects.requireNonNull(color);
	}

	/**
	 * 이 ColorPoint의 Point 뷰를 반환한다.
	 */
	public Point asPoint() {
		return point;
	}

	@Override
	public boolean equals(Object o) {
		// 객체의 동일성만 확인
		if (!(o instanceof ColorPoint)) {
			return false;
		}

		ColorPoint cp = (ColorPoint)o;

		// 자기가 가지고 있는 필드들을 검사
		return cp.point.equals(point) && cp.color.equals(color);
	}

	@Override
	public int hashCode() {
		return 31 * point.hashCode() + color.hashCode();
	}

	public static void main(String[] args) {
		Point p1 = new Point(1, 0);
		Point p2 = new ColorPoint(1, 0, Color.RED).asPoint();

		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p1));
	}
}
