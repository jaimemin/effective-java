package com.tistory.jaimemin.effectivejava.ch10.item73;

// 저수준 예외 클래스
class LowLevelException extends Exception {
	
	public LowLevelException(String message) {
		super(message);
	}
}
