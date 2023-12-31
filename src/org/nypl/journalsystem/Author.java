package org.nypl.journalsystem;

import org.nypl.journalsystem.core.IAuthor;

public class Author implements IAuthor{
	
	@Override
	public String toString() {
		return "\""+name+"\"";
	}
	
	String name;

	public Author(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
