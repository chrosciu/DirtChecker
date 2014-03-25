package com.chrosciu.dirtchecker.model;

import com.chrosciu.dirtchecker.annotation.Model;
import com.chrosciu.dirtchecker.annotation.Immutable;

@Model
public class Company {
	
	@Immutable
	private String address;
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	

}
