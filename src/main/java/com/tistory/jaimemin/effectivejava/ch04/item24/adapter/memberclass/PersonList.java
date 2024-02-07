package com.tistory.jaimemin.effectivejava.ch04.item24.adapter.memberclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PersonList implements Iterable<Person> {
	private List<Person> people;

	public PersonList() {
		this.people = new ArrayList<>();
	}

	public void addPerson(Person person) {
		people.add(person);
	}

	// Non-static inner adapter class implementing Iterator<Person>
	private class PersonIterator implements Iterator<Person> {
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < people.size();
		}

		@Override
		public Person next() {
			if (hasNext()) {
				return people.get(index++);
			} else {
				throw new IndexOutOfBoundsException("리스트에 더 이상 사람이 없습니다.");
			}
		}
	}

	// Override iterator() method to provide an instance of the inner adapter class
	@Override
	public Iterator<Person> iterator() {
		return new PersonIterator();
	}

	public static void main(String[] args) {
		PersonList personList = new PersonList();
		personList.addPerson(new Person("봉준호"));
		personList.addPerson(new Person("손흥민"));
		personList.addPerson(new Person("J-Park"));

		Iterator<Person> iterator = personList.iterator();

		while (iterator.hasNext()) {
			Person person = iterator.next();

			System.out.println(String.format("이름: %s", person.getName()));
		}
	}
}
