package org.nypl.journalsystem;

public class Publisher {
	
	@Override
	public String toString() {
		return name;
	}

	String name;
	String location;
	
	public Publisher(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
}
