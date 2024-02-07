package com.tistory.jaimemin.effectivejava.ch02.item07.optional;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class ChannelTest {

	@Test
	void npe() {
		Channel channel = new Channel();
		Optional<MemberShip> optional = channel.defaultMemberShip();
		optional.ifPresent(MemberShip::hello);
	}
}