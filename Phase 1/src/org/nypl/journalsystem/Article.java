package org.nypl.journalsystem;

import java.util.ArrayList;

public class Article {
	
	@Override
	public String toString() {
		return "[\"" + title + "\"" + ", authors=" + authors + "]";
	}

	String title;
	ArrayList<Author> authors;
	
	public Article(String title, ArrayList<Author> authors) {
		super();
		assert authors.size() > 0;
		this.title = title;
		this.authors = authors;
	}
}
