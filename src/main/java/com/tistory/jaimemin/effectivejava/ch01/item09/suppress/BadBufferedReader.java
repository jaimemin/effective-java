package com.tistory.jaimemin.effectivejava.ch01.item09.suppress;

import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamCorruptedException;

public class BadBufferedReader extends BufferedReader {
	
	public BadBufferedReader(Reader in, int sz) {
		super(in, sz);
	}

	public BadBufferedReader(Reader in) {
		super(in);
	}

	@Override
	public String readLine() throws IOException {
		throw new CharConversionException();
	}

	@Override
	public void close() throws IOException {
		throw new StreamCorruptedException();
	}
}
