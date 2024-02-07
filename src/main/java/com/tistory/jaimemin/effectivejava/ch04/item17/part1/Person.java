package com.tistory.jaimemin.effectivejava.ch04.item17.part1;

public final class Person {

	private final Address address;

	public Person(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		Address copyOfAddress = new Address();
		copyOfAddress.setStreet(address.getStreet());
		copyOfAddress.setZipCode(address.getZipCode());
		copyOfAddress.setCity(address.getCity());

		return copyOfAddress;
	}

	public static void main(String[] args) {
		Address seoul = new Address();
		seoul.setCity("서울");

		Person person = new Person(seoul);
		Address gyeongido = person.getAddress();
		gyeongido.setCity("경기도");

		System.out.println(person.address.getCity());
	}
}
