package com.tistory.jaimemin.effectivejava.ch08.item54;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

public class Example {

	private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

	private final List<Cheese> cheesesInStock = new ArrayList<>();

	public List<Cheese> getCheeses() {
		return new ArrayList<>(cheesesInStock);
		// return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
	}

	public Cheese[] getCheesesByArray() {
		return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
	}

	public static void main(String[] args) {
		Example example = new Example();
		List<Cheese> cheeses = example.getCheeses();

		if (!ObjectUtils.isEmpty(cheeses)) { // null-check
			for (Cheese cheese : cheeses) {
				System.out.println(cheese);
			}
		}
	}
}
