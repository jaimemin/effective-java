package com.tistory.jaimemin.effectivejava.ch03.item13;

public class HashTable implements Cloneable {

	private Entry[] buckets = new Entry[10]; // clone을 위해 final 키워드 떼야할 수도. 굳이?

	private static class Entry {

		final Object key;

		Object value;

		Entry next;

		Entry(Object key, Object value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public void add(Object key, Object value) {
			this.next = new Entry(key, value, null);
		}

		/**
		 * 재귀를 하다보면 StackOverflow 에러 발생 가능성
		 */
		// public Entry deepCopy() {
		// 	return new Entry(key, value, next == null ? null : next.deepCopy());
		// }
		public Entry deepCopy() {
			Entry result = new Entry(key, value, next);

			for (Entry p = result; p.next != null; p = p.next) {
				p.next = new Entry(p.next.key, p.next.value, p.next.next);
			}

			return result;
		}
	}

	/**
	 * hasTable -> entryH[],
	 * copy -> entryC[]
	 * entryH[0] == entryC[0]
	 */
	@Override
	public HashTable clone() {
		HashTable result = null;
		try {
			result = (HashTable)super.clone();
			result.buckets = this.buckets.clone(); // p82, shallow copy 라서 위험하다.
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	/**
	 * hasTable -> entryH[],
	 * copy -> entryC[]
	 * entryH[0] != entryC[0]
	 *
	 * 멀티쓰레드 환경에서는 synchronized 키워드까지 붙여야함
	 */
	// @Override
	// public HashTable clone() {
	// 	HashTable result = null;
	// 	try {
	// 		result = (HashTable)super.clone();
	// 		result.buckets = new Entry[this.buckets.length]; // 이 과정 꼭 포함
	//
	// 		for (int i = 0; i < this.buckets.length; i++) {
	// 			if (buckets[i] != null) {
	// 				result.buckets[i] = this.buckets[i].deepCopy(); // p83, deep copy
	// 			}
	// 		}
	//
	// 		return result;
	// 	} catch (CloneNotSupportedException e) {
	// 		throw new AssertionError();
	// 	}
	// }
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		Entry entry = new Entry(new Object(), new Object(), null);
		hashTable.buckets[0] = entry;
		HashTable clone = hashTable.clone();

		System.out.println(hashTable.buckets[0] == entry);
		System.out.println(hashTable.buckets[0] == clone.buckets[0]);
	}
}
