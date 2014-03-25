package com.chrosciu.dirtchecker.model;

import com.chrosciu.dirtchecker.annotation.Model;
import com.chrosciu.dirtchecker.annotation.Immutable;

@Model
public class Person { 
	
	@Immutable
	private String name;
	
	private String temporaryName;
	
	public Person() {
		this("", "");
	}
	
	public Person(String name, String temporaryName) {
		this.name = name;
		this.temporaryName = temporaryName;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTemporaryName(String name) {
		this.temporaryName = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTemporaryName() {
		return temporaryName;
	}

}
