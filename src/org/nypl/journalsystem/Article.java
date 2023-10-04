package org.nypl.journalsystem;

import java.util.ArrayList;
import org.nypl.journalsystem.core.IArticle;


public class Article implements IArticle{
	
	@Override
	public String toString() {
		return "[\"" + title + "\"" + ", authors=" + authors + "]";
	}

	String title;
	ArrayList<Author> authors;
	ArrayList<Article> citedArticles;
	
	public Article(String title, ArrayList<Author> authors, ArrayList<Article> citedArticles) {
		super();
		assert authors.size() > 0;
		this.title = title;
		this.authors = authors;
		this.citedArticles = citedArticles;
	}

	@Override
	public ArrayList<Author> getAuthors() {
		return authors;
	}

	@Override
	public String getTitle() {
		return title;
	}
	
	public void addCitation(Article citationArticle) {
		this.citedArticles.add(citationArticle);
	}

	public ArrayList<Article> getCitedArticles() {
		return citedArticles;
	}
}
