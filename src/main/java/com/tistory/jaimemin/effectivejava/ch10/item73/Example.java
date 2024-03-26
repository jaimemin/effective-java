package com.tistory.jaimemin.effectivejava.ch10.item73;

// 고수준의 예외 클래스
class DatabaseConnectionException extends Exception {

	public DatabaseConnectionException(String message, Throwable cause) {
		super(message, cause);
	}
}

public class Example {

	// public void connectToDatabase() throws DatabaseConnectionException {
	// 	try {
	// 		// 데이터베이스 연결 시도
	// 		// ...
	// 		// 여기서 SQLException 발생할 수 있음
	// 	} catch (SQLException e) {
	// 		// SQLException을 DatabaseConnectionException으로 변환하여 상위 레이어로 던짐
	// 		throw new DatabaseConnectionException("DB 연결에 실패했했습니다.", e);
	// 	}
	// }

	public static void main(String[] args) {
		try {
			// 고수준 예외 발생
			throw new HighLevelException("고수준 예외가 발생했습니다.");
		} catch (HighLevelException e) {
			// 저수준 예외 생성 및 연쇄
			LowLevelException lowLevelException = new LowLevelException("저수준 예외가 발생했습니다.");
			lowLevelException.initCause(new Throwable("고수준 예외의 원인입니다."));

			// 고수준 예외에 저수준 예외 연쇄
			e.initCause(lowLevelException);

			System.out.println("고수준 예외 메시지: " + e.getMessage());
			System.out.println("고수준 예외 원인: " + e.getCause().getMessage());
		}
	}

}
