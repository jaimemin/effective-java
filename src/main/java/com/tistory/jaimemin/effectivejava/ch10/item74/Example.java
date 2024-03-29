package com.tistory.jaimemin.effectivejava.ch10.item74;

import java.sql.SQLException;

/**
 * 이 클래스는 NullPointerException이 흔히 발생할 수 있으며,
 * 모든 메서드는 인수로 null이 전달될 경우 NullPointerException을 발생시킬 수 있습니다.
 */
public class Example {

	/**
	 * 예시 메서드입니다.
	 *
	 * @param input 입력 값 (null 허용 안 함)
	 * @throws NullPointerException 입력이 null인 경우 발생하는 예외
	 */
	public void exampleMethod(Object input) throws NullPointerException {
		if (input == null) {
			throw new NullPointerException("Input cannot be null.");
		}
		// 메서드 동작
	}

	/**
	 * 다른 예시 메서드입니다.
	 *
	 * @param data 데이터 (null 허용 안 함)
	 * @throws NullPointerException 데이터가 null인 경우 발생하는 예외
	 */
	public void anotherExampleMethod(String data) throws NullPointerException {
		if (data == null) {
			throw new NullPointerException("Data cannot be null.");
		}
		// 메서드 동작
	}

	// 다른 메서드들...

	/**
	 * 주어진 파라미터를 기준으로 데이터베이스를 조회하는 메서드입니다.
	 *
	 * @param param 데이터베이스 조회에 사용될 파라미터 (숫자형 데이터여야 함)
	 * @throws IllegalStateException - 메서드가 호출되는 상태가 부적절할 때 발생하는 예외
	 * @throws SQLException - 데이터베이스 조회 중 발생한 SQL 예외
	 * @throws NumberFormatException - param이 숫자형 데이터가 아닌 경우 발생하는 예외
	 */
	public void func(String param) throws IllegalStateException, SQLException, NumberFormatException {
		// param을 기준으로 DB 조회
	}
}

