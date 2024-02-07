package com.tistory.jaimemin.effectivejava.ch02.item03.staticfactory;

import java.util.function.Supplier;

/**
 * 장점: 정적 팩토리 메서드 참조를 공급자(Supplier)로 사용 가능
 *
 * java 8 이상 버전부터 Supplier interface 만 만족하면 어떠한 메서드던 Supplier functional type 으로 사용 가능
 * Supplier 를 구현하지 않았지만 Elvis 가 Supplier 에 준하기 때문에 가능한 코드
 */
public class Concert {

	public void start(Supplier<Singer> singerSupplier) {
		Singer singer = singerSupplier.get();
		singer.sing();
	}

	public static void main(String[] args) {
		Concert concert = new Concert();
		concert.start(Elvis::getInstance);
	}
}
