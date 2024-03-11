package com.tistory.jaimemin.effectivejava.ch08.item54;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ExampleTest {

	private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

	private final List<Cheese> cheesesInStock = new ArrayList<>();

	@Test
	public void test() {
		long start = System.currentTimeMillis();
		Cheese[] cheeses = getCheeses();
		long end = System.currentTimeMillis();

		log.info("duration: {}", (end - start));
	}

	@Test
	public void test2() {
		long start = System.currentTimeMillis();
		Cheese[] cheeses = getCheesesWithoutMemorize();
		long end = System.currentTimeMillis();

		log.info("duration: {}", (end - start));
	}

	private Cheese[] getCheesesWithoutMemorize() {
		return cheesesInStock.toArray(new Cheese[0]);
	}

	private Cheese[] getCheeses() {
		return cheesesInStock.toArray(new Cheese[cheesesInStock.size()]);
	}
}