package org.nypl.journalsystem;
import java.util.ArrayList;

public class Journal {
	
	String name;
	Publisher publisher;
	String ISSN;
	ArrayList<Article> articles;
	
	public Journal(String name, Publisher publisher, String ISSN, ArrayList<Article> articles) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.ISSN = ISSN;
		this.articles = articles;
		assert this.articles.size() > 0;
	}
	
	public boolean isFullIssue() {
			return (articles.size() > 2);
	}
	
	@Override
	public String toString() {
		if (this.isFullIssue()) {
			return "\"" + name + "\", articles="+ articles;	
		} else {
			return "\"" + name + "\" (not full issue), articles="+ articles;	
		}
	}
}
