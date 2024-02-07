package com.tistory.jaimemin.effectivejava.ch04.item18.callback;

public class Service {

	public void run(FunctionToCall functionToCall) {
		System.out.println("service run");
		functionToCall.call();
	}

	public static void main(String[] args) {
		Service service = new Service();
		Function function = new Function(service);
		FunctionWrapper functionWrapper = new FunctionWrapper(function);
		functionWrapper.run();
		// functionWrapper.call(); // 제대로 쓰고 싶다면 call()을 호출해야 함
	}
}
