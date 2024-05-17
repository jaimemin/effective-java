package com.tistory.jaimemin.effectivejava.ch12.item89;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;

// Broken singleton - has nontransient object reference field!
public class Elvis implements Serializable {

	private static final long serialVersionUID = -8870240565519414478L;

	public static final Elvis INSTANCE = new Elvis();

	private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

	private Elvis() {
	}

	public void printFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}

	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}

}
