package com.tistory.jaimemin.effectivejava.ch01.item08.cleaner;

import java.util.List;

public class BigObject {

	private List<Object> resource;

	public BigObject(List<Object> resource) {
		this.resource = resource;
	}

	/**
	 * finalize가 하는 일을 별도의 Runnable로 구현
	 * Runnable 구쳔체에서 절대 클린해야할 Object를 참조하면 안됨
	 * GC할 때 Object를 참조해버리면 오히려 부활해버릴 수 있음
	 */
	public static class ResourceCleaner implements Runnable {

		/**
		 * BigObject를 직접 참조하는 것이 아니라
		 * 정리해야할 resource 참조
		 */
		private List<Object> resourceToClean;

		public ResourceCleaner(List<Object> resourceToClean) {
			this.resourceToClean = resourceToClean;
		}

		@Override
		public void run() {
			resourceToClean = null;
			System.out.println("cleaned up.");
		}
	}
}
