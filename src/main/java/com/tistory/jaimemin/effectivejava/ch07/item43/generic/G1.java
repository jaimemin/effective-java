package com.tistory.jaimemin.effectivejava.ch07.item43.generic;

interface G1 {
	<E extends Exception> Object m() throws Exception;
}
