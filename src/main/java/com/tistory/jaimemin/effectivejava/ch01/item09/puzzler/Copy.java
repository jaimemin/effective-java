package com.tistory.jaimemin.effectivejava.ch01.item09.puzzler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {
	private static final int BUFFER_SIZE = 8 * 1024;

	// 코드 9-2 자원이 둘 이상이면 try-finally 방식은 너무 지저분하다! (47쪽)
	static void copy(String src, String dst) throws IOException {
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst);

		try {
			byte[] buf = new byte[BUFFER_SIZE];
			int n;

			while ((n = in.read(buf)) >= 0) {
				out.write(buf, 0, n);
			}
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// 이렇게 하면 되는거 아닌가?
				/**
				 * IOException이 아니라 RuntimeException이 발생한다면?
				 * in.close() X
				 */
			}

			try {
				in.close();
			} catch (IOException e) {
				// 안전한가?
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String src = args[0];
		String dst = args[1];
		copy(src, dst);
	}
}
