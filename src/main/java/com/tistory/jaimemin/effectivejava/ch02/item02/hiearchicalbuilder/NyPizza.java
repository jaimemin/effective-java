package com.tistory.jaimemin.effectivejava.ch02.item02.hiearchicalbuilder;

import java.util.Objects;

public class NyPizza extends Pizza {
	public enum Size {SMALL, MEDIUM, LARGE}

	private final Size size;

	public static class Builder extends Pizza.Builder<NyPizza.Builder> {
		private final Size size;

		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		public NyPizza build() {
			return new NyPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	private NyPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}

	@Override
	public String toString() {
		return toppings + "로 토핑한 뉴욕 피자";
	}
}
