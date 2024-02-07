package com.tistory.jaimemin.effectivejava.ch02.item07.listener;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.ref.WeakReference;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * listener나 callback을 제거해주는 기능이 없으면
 * 유저가 어떠한 이유에서 떠나더라도 Collection에 그대로 남아 있는 문제
 * WeakReference를 사용할 경우 Weak Reference보다 강한 참조가 아닐 경우 제거 됨
 */
class ChatRoomTest {

	@Test
	void chatRoom() throws InterruptedException {
		ChatRoom chatRoom = new ChatRoom();
		User user1 = new User();
		User user2 = new User();

		chatRoom.addUser(user1);
		chatRoom.addUser(user2);

		chatRoom.sendMessage("hello");
		// System.out.println(chatRoom.getUsers().size());

		user1 = null;
		System.gc();
		Thread.sleep(5000L);

		List<WeakReference<User>> users = chatRoom.getUsers();
		chatRoom.sendMessage("bye");
		assertTrue(users.size() == 1);
	}
}