package com.tistory.jaimemin.effectivejava.ch03.item15.item;

import com.tistory.jaimemin.effectivejava.ch03.item15.member.MemberService;

public class ItemService {

	private final MemberService memberService;

	boolean onSale; // package-private

	protected int saleRate;

	public ItemService(MemberService memberService) {
		if (memberService == null) {
			throw new IllegalArgumentException("MemberService should not be null.");
		}

		this.memberService = memberService;
	}

	MemberService getMemberService() {
		return memberService;
	}
}
