package com.tistory.jaimemin.effectivejava.ch12.item89;

import java.io.Serializable;

public class ElvisStealer implements Serializable {

	private static final long serialVersionUID = 0;

	static Elvis impersonator;

	private Elvis payload;

	private Object readResolve() {
		// Save a reference to the "unresolved" Elvis instance
		impersonator = payload;

		// Return an object of correct type for favorites field
		return new String[] {"A Fool Such as I"};
	}

}