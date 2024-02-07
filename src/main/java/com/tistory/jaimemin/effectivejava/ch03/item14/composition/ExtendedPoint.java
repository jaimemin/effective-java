package com.tistory.jaimemin.effectivejava.ch03.item14.composition;

/**
 * 컴포지션의 경우 Comparable을 재정의 가능
 * 이게 상속보다 더 깔끔
 */
public class ExtendedPoint implements Comparable<ExtendedPoint> {

	private final Point point;
	private final Integer z;

	public ExtendedPoint(Point point, int z) {
		this.point = point;
		this.z = z;
	}

	/**
	 * Point 뷰 제공도 가능
	 */
	public Point getPoint() {
		return this.point;
	}

	@Override
	public int compareTo(ExtendedPoint extendedPoint) {
		int result = this.point.compareTo(extendedPoint.point);

		if (result == 0) {
			result = this.z.compareTo(extendedPoint.z);
		}

		return result;
	}
}
