package com.tistory.jaimemin.effectivejava.ch01.item07.optional;

import java.util.Optional;

public class Channel {

	private int numOfSubscribers;

	/**
	 * return type 이 null 일 경우 Optional 로 감싸서 반환하는 습관이 좋음
	 * 사용하는 쪽에서 Optional 로 받게 되고 Optional 에서 꺼내야지만 메서드 호출할 수 있어 보다 안정적
	 */
	public Optional<MemberShip> defaultMemberShip() {
		if (this.numOfSubscribers < 2000) {
			return Optional.empty();
		} else {
			return Optional.of(new MemberShip());
		}
	}
}
