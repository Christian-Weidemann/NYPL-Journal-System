package org.nypl.journalsystem;

import org.nypl.journalsystem.core.IPublisher;

public class Publisher implements IPublisher{
	
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

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public String getName() {
		return name;
	}
}
