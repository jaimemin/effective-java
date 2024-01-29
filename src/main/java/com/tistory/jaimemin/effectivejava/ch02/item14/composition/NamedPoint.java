package com.tistory.jaimemin.effectivejava.ch02.item14.composition;

/**
 * 컴포지션의 경우 Comparable을 재정의 가능
 * 이게 상속보다 더 깔끔
 */
public class NamedPoint implements Comparable<NamedPoint> {

	private final Point point;
	private final String name;

	public NamedPoint(Point point, String name) {
		this.point = point;
		this.name = name;
	}

	/**
	 * Point 뷰 제공도 가능
	 */
	public Point getPoint() {
		return this.point;
	}

	@Override
	public int compareTo(NamedPoint namedPoint) {
		int result = this.point.compareTo(namedPoint.point);

		if (result == 0) {
			result = this.name.compareTo(namedPoint.name);
		}

		return result;
	}
}
