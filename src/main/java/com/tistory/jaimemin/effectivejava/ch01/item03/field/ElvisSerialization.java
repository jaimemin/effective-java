package com.tistory.jaimemin.effectivejava.ch01.item03.field;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 역직렬화로 여러 인스턴스 만들기
 *
 * 싱글톤 허점: 역직렬화를 통해 새로운 인스턴스 만들어짐
 */
public class ElvisSerialization {

	public static void main(String[] args) {
		// 직렬화
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
			out.writeObject(Elvis.INSTANCE);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 역직렬화
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))) {
			Elvis elvis3 = (Elvis)in.readObject();
			System.out.println(elvis3 == Elvis.INSTANCE);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
