package org.nypl.journalsystem;

import java.util.ArrayList;
import java.util.List;

import org.nypl.journalsystem.core.IArticle;
import org.nypl.journalsystem.core.IAuthor;

public class Article implements IArticle{
	
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

	@Override
	public List<? extends IAuthor> getAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
}
