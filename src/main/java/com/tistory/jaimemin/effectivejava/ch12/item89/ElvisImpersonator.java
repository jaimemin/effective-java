package com.tistory.jaimemin.effectivejava.ch12.item89;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class ElvisImpersonator {

	// Byte stream could not have come from real Elvis instance!
	private static final byte[] serializedForm = new byte[] {(byte)0xac, (byte)0xed, 0x00, 0x05, 0x73, 0x72, 0x00,
		0x05, 0x45, 0x6c, 0x76, 0x69, 0x73, (byte)0x84, (byte)0xe6, (byte)0x93, 0x33, (byte)0xc3, (byte)0xf4,
		(byte)0x8b, 0x32, 0x02, 0x00, 0x01, 0x4c, 0x00, 0x0d, 0x66, 0x61, 0x76, 0x6f, 0x72, 0x69, 0x74, 0x65, 0x53,
		0x6f, 0x6e, 0x67, 0x73, 0x74, 0x00, 0x12, 0x4c, 0x6a, 0x61, 0x76, 0x61, 0x2f, 0x6c, 0x61, 0x6e, 0x67, 0x2f,
		0x4f, 0x62, 0x6a, 0x65, 0x63, 0x74, 0x3b, 0x78, 0x70, 0x73, 0x72, 0x00, 0x0c, 0x45, 0x6c, 0x76, 0x69, 0x73,
		0x53, 0x74, 0x65, 0x61, 0x6c, 0x65, 0x72, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0x00, 0x01,
		0x4c, 0x00, 0x07, 0x70, 0x61, 0x79, 0x6c, 0x6f, 0x61, 0x64, 0x74, 0x00, 0x07, 0x4c, 0x45, 0x6c, 0x76, 0x69,
		0x73, 0x3b, 0x78, 0x70, 0x71, 0x00, 0x7e, 0x00, 0x02};

	public static void main(String[] args) {
		// Initializes ElvisStealer.impersonator and returns
		// the real Elvis (which is Elvis.INSTANCE)
		Elvis elvis = (Elvis)deserialize(serializedForm);
		Elvis impersonator = ElvisStealer.impersonator;

		elvis.printFavorites();
		impersonator.printFavorites();
	}

	// Returns the object with the specified serialized form
	private static Object deserialize(byte[] sf) {
		try (InputStream is = new ByteArrayInputStream(sf);
			 ObjectInputStream ois = new ElvisImpersonator.CustomObjectInputStream(is)) {
			return ois.readObject();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	private static class CustomObjectInputStream extends ObjectInputStream {
		public CustomObjectInputStream(InputStream in) throws IOException {
			super(in);
		}

		@Override
		protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
			String name = desc.getName();

			if ("ElvisStealer".equals(name)) {
				return com.tistory.jaimemin.effectivejava.ch12.item89.ElvisStealer.class;
			}
			if ("Elvis".equals(name)) {
				return com.tistory.jaimemin.effectivejava.ch12.item89.Elvis.class;
			}

			return super.resolveClass(desc);
		}
	}

}
