package com.tistory.jaimemin.effectivejava.ch02.item10.inheritance;

import java.util.Set;

import com.tistory.jaimemin.effectivejava.ch02.item10.Point;

// CounterPoint를 Point로 사용하는 테스트 프로그램
public class CounterPointTest {
	// 단위 원 안의 모든 점을 포함하도록 unitCircle을 초기화한다. (58쪽)
	private static final Set<Point> unitCircle = Set.of(
		new Point(1, 0), new Point(0, 1),
		new Point(-1, 0), new Point(0, -1));

	/**
	 * 상위 클래스를 줬더니 true
	 * 하위 클래스를 줬더니 false?
	 * 리스코프 치환원칙 깨짐
	 */
	public static boolean onUnitCircle(Point p) {
		return unitCircle.contains(p);
	}

	public static void main(String[] args) {
		Point p1 = new Point(1, 0);
		Point p2 = new CounterPoint(1, 0);

		// true를 출력한다.
		System.out.println(onUnitCircle(p1));

		/**
		 * 리스코프 치환법칙 고려해야함
		 * true를 출력해야 하지만, Point의 equals가 getClass를 사용해 작성되었다면 그렇지 않다.
		 * getClass()가 다르므로 리스코프 치환법칙 위반
		 * 상속을 사용했을 때 CounterPoint는 다른 필드를 정의하지 않았기 때문에 상위 클래스의 equals를 사용해도 무방
		 * ColorPoint는 다른 필드를 추가했기 때문에 추이성이나 대칭성을 위반하지 않는 equals를 추가하는 방법 없음
		 */
		System.out.println(onUnitCircle(p2));
	}
}