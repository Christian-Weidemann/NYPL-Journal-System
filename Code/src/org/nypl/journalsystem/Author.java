package org.nypl.journalsystem;

public class Author {
	
	@Override
	public String toString() {
		return "\""+name+"\"";
	}
	
	String name;

	public Author(String name) {
		super();
		this.name = name;
	}

}
