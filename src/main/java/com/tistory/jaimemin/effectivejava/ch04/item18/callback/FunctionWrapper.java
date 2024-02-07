package com.tistory.jaimemin.effectivejava.ch04.item18.callback;

public class FunctionWrapper implements FunctionToCall {

	private final Function function;

	public FunctionWrapper(Function function) {
		this.function = function;
	}

	@Override
	public void call() {
		this.function.call();

		System.out.println("functionWrapper 호출");
	}

	@Override
	public void run() {
		this.function.run();
	}
}
