package com.tistory.jaimemin.effectivejava.ch02.item08.finalizer;

public class FinalizerIsBad {

	/**
	 * java 9부터 deprecated
	 *
	 * AutoClosable이 가장 적절한 해결책
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.print("");
	}
}