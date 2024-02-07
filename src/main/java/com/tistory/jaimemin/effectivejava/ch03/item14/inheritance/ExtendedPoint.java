package com.tistory.jaimemin.effectivejava.ch03.item14.inheritance;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 상속을 했을 때 비교를 어떻게 하지?
 * 상위 타입에서 Compareable을 정의했기 때문에 하위 타입에서 재정의할 수 없음
 */
public class ExtendedPoint extends Point {

	final private int z;

	public ExtendedPoint(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "NamedPoint{" +
			"z='" + z + '\'' +
			", x=" + x +
			", y=" + y +
			'}';
	}

	public static void main(String[] args) {
		ExtendedPoint p1 = new ExtendedPoint(1, 0, 4);
		ExtendedPoint p2 = new ExtendedPoint(1, 0, 3);

		/**
		 * 별도의 comparator를 제공하여 비교하는 방식을 가져가야 함
		 */
		Set<ExtendedPoint> points = new TreeSet<>(new Comparator<ExtendedPoint>() {
			@Override
			public int compare(ExtendedPoint p1, ExtendedPoint p2) {
				int result = Integer.compare(p1.getX(), p2.getX());

				if (result == 0) {
					result = Integer.compare(p1.getY(), p2.getY());
				}

				if (result == 0) {
					result = Integer.compare(p1.getZ(), p2.getZ());
				}

				return result;
			}
		});

		points.add(p1);
		points.add(p2);

		System.out.println(points);
	}

}
