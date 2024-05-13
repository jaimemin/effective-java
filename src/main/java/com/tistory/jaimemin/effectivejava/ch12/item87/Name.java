package com.tistory.jaimemin.effectivejava.ch12.item87;

import java.io.Serializable;

public class Name implements Serializable {

	/**
	 * 성. null이 아니어야함
	 * @serial
	 */
	private final String lastName;

	/**
	 * 이름. null이 아니어야 함.
	 * @serial
	 */
	private final String firstName;

	/**
	 * 중간이름. 중간이름이 없다면 null.
	 * @serial
	 */
	private final String middleName;

	public Name(String lastName, String firstName, String middleName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
	}
}