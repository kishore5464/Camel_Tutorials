package com.kishore.model;

public class Books {
	private Integer id;
	private String bookName;
	private String authorName;

	public Books() {
		super();
	}

	public Books(Integer id, String bookName, String authorName) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + "]";
	}
}
