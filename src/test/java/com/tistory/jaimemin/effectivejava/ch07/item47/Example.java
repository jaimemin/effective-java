package com.tistory.jaimemin.effectivejava.ch07.item47;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class Example {

	public static <E> Iterable<E> iterableOf(Stream<E> stream) {
		return stream::iterator;
	}

	@Test
	void test() {
		for (ProcessHandle ph : iterableOf(ProcessHandle.allProcesses())) {
		}
	}
}
