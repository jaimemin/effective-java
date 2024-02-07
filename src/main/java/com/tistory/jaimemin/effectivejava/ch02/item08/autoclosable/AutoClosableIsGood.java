package com.tistory.jaimemin.effectivejava.ch02.item08.autoclosable;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AutoClosableIsGood implements Closeable {

	private BufferedReader reader;

	public AutoClosableIsGood(String path) {
		try {
			this.reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(path);
		}
	}

	/**
	 * close 메서드를 구현하면 AutoClosable 처리 가능
	 *
	 * 클라이언트 코드에서 굳이 예외를 잡지 않아도 됨
	 * 다만 RuntimeException 던졌으므로 해당 쓰레드는 에러가 났기 때문에 종료가 됨
	 * 종료를 원치 않다면 logging만
	 *
	 * idempotent: 몇 번을 실행했음에도 불구하고 같은 결과가 발생해야함 (멱등성)
	 */
	@Override
	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
