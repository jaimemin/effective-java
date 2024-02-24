package com.tistory.jaimemin.effectivejava.ch06.item34;

public class EnumPattern {

	public static final int APPLE_FUJI = 0;
	public static final int APPLE_PIPPIN = 1;
	public static final int APPLE_GRANNY_SMITH = 2;

	public static final int ORANGE_NAVEL = 0;
	public static final int ORANGE_TEMPLE = 1;
	public static final int ORANGE_BLOOD = 2;

	public static void main(String[] args) {
		System.out.println(APPLE_FUJI == ORANGE_TEMPLE);
	}
}
