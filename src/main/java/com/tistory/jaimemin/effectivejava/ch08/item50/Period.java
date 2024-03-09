package com.tistory.jaimemin.effectivejava.ch08.item50;

import java.util.Date;

// Broken "immutable" time period class (Pages 231-3)
public final class Period {

	private final Date start;

	private final Date end;

	// /**
	//  * @param  start the beginning of the period
	//  * @param  end the end of the period; must not precede start
	//  * @throws IllegalArgumentException if start is after end
	//  * @throws NullPointerException if start or end is null
	//  */
	// public Period(Date start, Date end) {
	// 	if (start.compareTo(end) > 0) {
	// 		throw new IllegalArgumentException(
	// 			start + " after " + end);
	// 	}
	//
	// 	this.start = start;
	// 	this.end = end;
	// }
	//
	// public Date start() {
	// 	return start;
	// }
	//
	// public Date end() {
	// 	return end;
	// }
	//
	public String toString() {
		return start + " - " + end;
	}

	// Repaired constructor - makes defensive copies of parameters (Page 232)
	public Period(Date start, Date end) {
		// this.start = (Date)start.clone();
		// this.end = (Date)end.clone();
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());

		if (this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(
				this.start + " after " + this.end);
	}

	// Repaired accessors - make defensive copies of internal fields (Page 233)
	public Date start() {
		return new Date(start.getTime());
	}

	public Date end() {
		return new Date(end.getTime());
	}

	// Remainder omitted

	public static void main(String[] args) {
		Date start = new Date();
		Date end = new Date();
		Period period = new Period(start, end);
		System.out.println(period);

		// 불변식 깨짐
		period.end().setYear(78);
		System.out.println(period);
	}
}
