package com.tistory.jaimemin.effectivejava.ch02.item02.hiearchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * 코드 2-4 계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴 (19쪽)
 *
 * 참고: 여기서 사용한 '시뮬레이트한 셀프 타입(simulated self-type)' 관용구는
 * 빌더뿐 아니라 임의의 유동적인 계층구조를 허용한다.
 */
public abstract class Pizza {
	public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

	final Set<Topping> toppings;

	/**
	 * 추상 빌더 - 재귀적인 타입 제안
	 */
	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));

			/**
			 * this 를 반환할 경우 Builder<T>를 반환하게 되고 이는 하위 타입이 아닌 자기 자신 즉 Pizza 를 return
			 * self()를 반환해야 하위 클래스를 반환 (Calzone 혹은 NyPizza)
			 */
			return self();
		}

		abstract Pizza build();

		/**
		 * 하위 클래스는 이 메서드를 재정의(overriding)하여
		 * "this"를 반환하도록 해야 한다.
		 */
		protected abstract T self();
	}

	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone(); // 아이템 50 참조
	}
}
