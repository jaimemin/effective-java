package com.tistory.jaimemin.effectivejava.ch12.item86;

import java.io.Serializable;

class MyClass implements Serializable {

	private static long serialVersionUID = 1L;

	private String data;

	private String newData;

	public MyClass() {
	}

	public MyClass(String data) {
		if (data.equals("data")) {
			throw new IllegalArgumentException("data can't be data");
		}

		this.data = data;
	}

	public String getData() {
		return data;
	}

	public String getNewData() {
		return newData;
	}

}
