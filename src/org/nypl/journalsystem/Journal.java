package org.nypl.journalsystem;
import java.util.ArrayList;
import java.util.Collection;

import org.nypl.journalsystem.core.IArticle;
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
	public Collection<? extends IArticle> getArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIssn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPublisher getPublisher() {
		// TODO Auto-generated method stub
		return null;
	}
}
