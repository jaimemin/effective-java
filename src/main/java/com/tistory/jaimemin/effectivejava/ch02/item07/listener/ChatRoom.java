package com.tistory.jaimemin.effectivejava.ch02.item07.listener;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/**
 * 레퍼런스는 네 가지 종류
 * Strong: Object를 = 으로 할당 (우리가 일반적으로 사용하는 케이스)
 * Soft
 * Weak
 * Phantom
 */
public class ChatRoom {

	private CustomWeakReferenceList<User> users;

	public ChatRoom() {
		this.users = new CustomWeakReferenceList<>();
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public void sendMessage(String message) {
		users.getList().forEach(wr -> Objects.requireNonNull(wr.get()).receive(message));
	}

	public List<WeakReference<User>> getUsers() {
		return users.getList();
	}
}
