package com.tistory.jaimemin.effectivejava.ch02.item02.builder;

/**
 * 코드 2-3 빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다. (17~18쪽)
 */
public class NutritionFacts {

	private final int servingSize;

	private final int servings;

	private final int calories;

	private final int fat;

	private final int sodium;

	private final int carbohydrate;

	public static void main(String[] args) {
		/**
		 * 장점: javabeans 보다 훨씬 consistent 하게 객체 생성 가능 (필수로 필요한 필드들을 생성자를 통해 반드시 가져올 수 있게 강제할 수 있음)
		 * -> optional 한 필드들은 체이닝을 통해 optional 하게 가져올 수 있음
		 *
		 * 단점: 오히려 코드 이해를 어렵게 할 수 있음 (내부 static class 가 있기 때문에)
		 * -> Lombok 의 @Builder 사용하면 해결 가능
		 *
		 * Lombok 의 단점
		 * 1. 기본적으로 모든 매개변수를 받는 생성자가 생기는 단점 (필드들이 노출)
		 * -> AllArgsConstructor(access = AccessLevel.PRIVATE) 선언 시 Builder 만 강제할 수 있음
		 * 2. 필수 값을 지정하기 어려움
		 * -> 명시적으로 코드를 작성했을 때는 생성자를 통해 필수값을 받고 체이닝을 통해 optional 한 값들을 받도록하면 됨
		 * -> Lombok의 Builder는 이렇게 처리하기 어려움
		 */
		NutritionFacts cocaCola = new Builder(240, 8)
			.calories(100)
			.sodium(35)
			.carbohydrate(27)
			.build();
	}

	public static class Builder {
		// required fields
		private final int servingSize;

		private final int servings;

		// optional fields
		private int calories = 0;

		private int fat = 0;

		private int sodium = 0;

		private int carbohydrate = 0;

		/**
		 * 필수 값들은 생성자로
		 */
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		/**
		 * Setter와 가장 큰 차이점은 return type 이 void 가 아닌 Builder Type
		 */
		public Builder calories(int val) {
			calories = val;

			return this;
		}

		public Builder fat(int val) {
			fat = val;

			return this;
		}

		public Builder sodium(int val) {
			sodium = val;

			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;

			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
}