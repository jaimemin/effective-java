package com.tistory.jaimemin.effectivejava.ch02.item08.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsNotGood {

	/**
	 * PhantomReference랑 비슷
	 *
	 * 권장하는 방법은 AutoClosable
	 */
	public static void main(String[] args) throws InterruptedException {
		Cleaner cleaner = Cleaner.create();

		List<Object> resourceToCleanUp = new ArrayList<>();
		BigObject bigObject = new BigObject(resourceToCleanUp);
		cleaner.register(bigObject, new BigObject.ResourceCleaner(resourceToCleanUp));

		bigObject = null;
		System.gc();
		Thread.sleep(3000L);
	}

}