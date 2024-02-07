package com.tistory.jaimemin.effectivejava.ch02.item07.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 팬텀 레퍼런스만 남은 경우에 gc가 돌면 본래 가지고 있던 object는 정리하고
 * 팬텀 레퍼런스는 레퍼런스 큐에 넣어줌
 * 나중에 레퍼런스 큐에 꺼내서 정리할 수 있음
 * <p>
 * 용도
 * 1. 자원 정리 (finalize 보다는 나은 리소스 정리 방법) -> 그래도 굳이 이 방법을 사용하지 않음 (최상의 방법은 try-resource)
 * 2. 언제 무거운 객체가 메모리 해제되는지 알 수 있음 (사라짐과 동시에 큐에 들어가기 때문에 큐를 확인할 수 있음, 정말 메모리에 민감한 애플리케이션에서만 사용)
 */
public class PhantomReferenceExample {

	public static void main(String[] args) throws InterruptedException {
		BigObject strong = new BigObject();
		ReferenceQueue<BigObject> rq = new ReferenceQueue<>();

		// 무조건 reference queue를 넘겨줘야 함
		BigObjectReference<BigObject> phantom = new BigObjectReference<>(strong, rq);
		strong = null; // strong instance 대신 남아있음

		System.gc();
		Thread.sleep(3000L);

		/**
		 * 팬텀은 유령이니까..
		 * 죽었지만.. 사라지진 않고 큐에 들어갑니다.
		 */
		System.out.println(phantom.isEnqueued());

		Reference<? extends BigObject> reference = rq.poll();
		BigObjectReference bigObjectCleaner = (BigObjectReference)reference;
		bigObjectCleaner.cleanUp(); // 커스텀한 reference queue를 선언해야 자원 정리를 명시적으로 진행 가능
		reference.clear();
	}
}
