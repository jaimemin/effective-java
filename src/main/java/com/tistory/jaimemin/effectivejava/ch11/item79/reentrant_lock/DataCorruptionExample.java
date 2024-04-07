package com.tistory.jaimemin.effectivejava.ch11.item79.reentrant_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataCorruptionExample {

	private static Lock lock = new ReentrantLock();

	private static int data = 0;

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			try {
				lock.lock();
				System.out.println("Thread 1 acquired lock.");
				// Simulate some work
				Thread.sleep(1000);
				corruptData();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
				System.out.println("Thread 1 released lock.");
			}
		});

		Thread thread2 = new Thread(() -> {
			try {
				lock.lock();
				System.out.println("Thread 2 acquired lock.");
				// Simulate some work
				Thread.sleep(1000);
				modifyData();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
				System.out.println("Thread 2 released lock.");
			}
		});

		thread1.start();
		thread2.start();
	}

	private static void corruptData() {
		// This method is called from within the lock of Thread 1
		// Thread 2 tries to acquire the lock again in modifyData method
		// This can lead to data corruption as both threads access 'data' concurrently
		data = 10; // This should not be reached if proper synchronization is used
		System.out.println("Data corrupted by Thread 1.");
	}

	private static void modifyData() {
		// This method is called from within the lock of Thread 2
		// This method is invoked after corruptData() by Thread 1
		// The lock is already held by Thread 2 due to its reentrant nature
		// Hence, Thread 2 can access 'data' even though it should not be accessible yet
		System.out.println("Data modified by Thread 2: " + data);
	}
}



