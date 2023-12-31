package org.nypl.journalsystem;
import java.util.ArrayList;

import org.nypl.journalsystem.core.IJournal;
import org.nypl.journalsystem.core.IPublisher;

public class Journal implements IJournal{
	
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

	@Override
	public ArrayList<Article> getArticles() {
		return articles;
	}

	@Override
	public String getIssn() {
		return ISSN;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IPublisher getPublisher() {
		return publisher;
	}
}

