package com.tistory.jaimemin.effectivejava.ch02.item03.field;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcertTest {

	@Test
	void perform() {
		/**
		 * Concert 를 테스트하기 위해 Elvis 인스턴스를 불러오는 것이 아닌 mocking
		 *
		 * ConcertTest 에서 Elvis 의 인스턴스를 가져와서 매번 노래를 부르게 하면 리소스를 지속적으로 사용하여 낭비
		 * 그래서 Elvis 를 인터페이스화 하여 MockElvis 를 만들고 Elvis 인스턴스를 대체해서 Concert 의 테스트를 좀 더 유연하게 진행
		 *
		 * Elvis 객체의 sing 메서드가 외부 API를 호출하고 이를 테스트한다고 가정해보겠습니다. 외부 API는 호출 횟수에 따라 price가 생길 수 있다면, 수십번 테스트와 함께 호출되면 안될 것입니다.
		 * (price 발생 없이 test 시간만 오래 걸리는 경우도 마찬가지입니다.)
		 *
		 * 테스트는 sing 메서드가 잘 호출 됐는지, 외부 API를 호출하는지를 검증하고 싶으므로, 실제 API 호출은 불필요합니다. 때문에 MockElvis를 만들면 실제 API 호출을 제거하여 비용을 줄일 수 있다는 의미로 이해했습니다!
		 */
		// Concert concert = new Concert(Elvis.INSTANCE);
		Concert concert = new Concert(new MockElvis());
		concert.perform();

		assertThat(concert.isLightsOn()).isTrue();
		assertThat(concert.isMainStateOpen()).isTrue();
	}
}