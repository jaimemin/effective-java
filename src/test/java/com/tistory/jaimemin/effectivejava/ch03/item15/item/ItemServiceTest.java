package com.tistory.jaimemin.effectivejava.ch03.item15.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.tistory.jaimemin.effectivejava.ch03.item15.member.MemberService;

class ItemServiceTest {

	@Mock
	MemberService memberService;

	@Test
	void itemService() {
		ItemService service = new ItemService(memberService);
		assertNotNull(service);
		assertNotNull(service.getMemberService());
	}

}