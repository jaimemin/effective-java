package com.tistory.jaimemin.effectivejava.ch05.item26.genericdao;

public class Message implements Entity {

	private Long id;

	private String body;

	@Override
	public Long getId() {
		return id;
	}

	public String getBody() {
		return body;
	}
}
