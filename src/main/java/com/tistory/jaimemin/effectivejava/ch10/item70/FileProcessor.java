package com.tistory.jaimemin.effectivejava.ch10.item70;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

	private String filename;

	public FileProcessor(String filename) {
		this.filename = filename;
	}

	// 파일을 읽어오는 메서드
	public void readFile() throws FileProcessingException {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;

			while ((line = br.readLine()) != null) {
				// 파일 내용을 처리하는 로직
				// 예를 들어, 파일에서 데이터를 읽어와서 처리하는 작업
				System.out.println(line);
			}
		} catch (IOException e) {
			// 파일 처리 중 예외 발생 시, FileProcessingException을 던짐
			throw new FileProcessingException("파일을 읽어오는 중 오류 발생", e);
		}
	}

	// 파일 처리 중 발생한 예외를 표현하는 사용자 정의 예외 클래스
	public static class FileProcessingException extends Exception {

		public FileProcessingException(String message, Throwable cause) {
			super(message, cause);
		}

		// 예외 상황을 해결하기 위해 필요한 정보를 제공하는 메서드
		public void resolveIssue() {
			// 예를 들어, 파일 경로를 확인하거나, 파일 권한을 확인하는 메시지 출력
			System.out.println("파일 경로를 확인하거나, 파일 권한을 확인하세요.");
		}
	}

	public static void main(String[] args) {
		String filename = "nonexistent_file.txt"; // 존재하지 않는 파일 경로를 지정
		FileProcessor processor = new FileProcessor(filename);

		try {
			processor.readFile();
		} catch (FileProcessingException e) {
			System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
			// 파일 처리 중 발생한 예외를 해결하기 위한 정보를 제공하는 메서드 호출
			e.resolveIssue();
		}
	}
}
