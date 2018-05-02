package com.gantang.model;

public class Annotation {

	private String authorName;
	private String date;

	public Annotation(String authorName, String date) {
		super();
		this.authorName = authorName;
		this.date = date;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Annotation [authorName=" + authorName + ", date=" + date + "]";
	}

}
