package com.tistory.jaimemin.effectivejava.ch02.item14.inheritance;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 상속을 했을 때 비교를 어떻게 하지?
 * 상위 타입에서 Compareable을 정의했기 때문에 하위 타입에서 재정의할 수 없음
 */
public class NamedPoint extends Point {

	final private String name;

	public NamedPoint(int x, int y, String name) {
		super(x, y);
		this.name = name;
	}

	@Override
	public String toString() {
		return "NamedPoint{" +
			"name='" + name + '\'' +
			", x=" + x +
			", y=" + y +
			'}';
	}

	public static void main(String[] args) {
		NamedPoint p1 = new NamedPoint(1, 0, "jaimemin");
		NamedPoint p2 = new NamedPoint(1, 0, "gudetama");

		/**
		 * 별도의 comparator를 제공하여 비교하는 방식을 가져가야 함
		 */
		Set<NamedPoint> points = new TreeSet<>(new Comparator<NamedPoint>() {
			@Override
			public int compare(NamedPoint p1, NamedPoint p2) {
				int result = Integer.compare(p1.getX(), p2.getX());

				if (result == 0) {
					result = Integer.compare(p1.getY(), p2.getY());
				}

				if (result == 0) {
					result = p1.name.compareTo(p2.name);
				}

				return result;
			}
		});

		points.add(p1);
		points.add(p2);

		System.out.println(points);
	}

}
