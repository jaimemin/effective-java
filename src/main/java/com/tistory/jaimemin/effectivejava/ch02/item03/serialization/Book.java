package com.tistory.jaimemin.effectivejava.ch02.item03.serialization;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 직렬화 이후 역직렬화하는 와중 클래스가 바뀌면 serialVersionUID 가 다르다고 에러 뜸
 * (serialVersionUID 자동생성일 경우)
 *
 * 명시적으로 serialVersionUID 를 선언하면 클래스 내용이 바뀌더라도 serialVersionUID 가 다르더라도 역직렬화가 됨
 */
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	private String isbn;

	private String title;

	private LocalDate published;

	private String name;

	private transient int numberOfSold; // 직렬화 하지 않기 위해서는 transient

	public Book(String isbn, String title, String author, LocalDate published) {
		this.isbn = isbn;
		this.title = title;
		this.published = published;
	}

	@Override
	public String toString() {
		return "Book{" +
			"isbn='" + isbn + '\'' +
			", title='" + title + '\'' +
			", published=" + published +
			", numberOfSold=" + numberOfSold +
			'}';
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getPublished() {
		return published;
	}

	public void setPublished(LocalDate published) {
		this.published = published;
	}

	public int getNumberOfSold() {
		return numberOfSold;
	}

	public void setNumberOfSold(int numberOfSold) {
		this.numberOfSold = numberOfSold;
	}
}
