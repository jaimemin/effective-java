package com.tistory.jaimemin.effectivejava.ch12.item89.enumSingleton;

import java.util.Arrays;

public enum Elvis {

	INSTANCE;

	private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

	public void printFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}
}
