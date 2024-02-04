package com.tistory.jaimemin.effectivejava.ch03.item18.callback;

class Function implements FunctionToCall {

	private final Service service;

	public Function(Service service) {
		this.service = service;
	}

	@Override
	public void call() {
		System.out.println("function 호출");
	}

	@Override
	public void run() {
		this.service.run(this);
	}
}
