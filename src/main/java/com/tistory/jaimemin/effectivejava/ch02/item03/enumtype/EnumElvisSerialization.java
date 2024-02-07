package com.tistory.jaimemin.effectivejava.ch02.item03.enumtype;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.tistory.jaimemin.effectivejava.ch02.item03.field.Elvis;

/**
 * readResolve() 재정의 필요 없음
 */
public class EnumElvisSerialization {

	public static void main(String[] args) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
			out.writeObject(Elvis.INSTANCE);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))) {
			Elvis elvis = (Elvis)in.readObject();
			System.out.println(elvis == Elvis.INSTANCE);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}