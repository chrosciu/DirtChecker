package com.chrosciu.dirtchecker;

import com.chrosciu.dirtchecker.iface.DirtCheckable;
import com.chrosciu.dirtchecker.model.Company;
import com.chrosciu.dirtchecker.model.Person;

public class Main {

	public static void main(String[] args) {
		Person person1 = new Person("Nowak", "Nowak");
		System.out.println(((DirtCheckable)person1).isDirty());
		person1.setTemporaryName("Kowalski");
		System.out.println(((DirtCheckable)person1).isDirty());
		person1.setName("Kowalski");
		System.out.println(((DirtCheckable)person1).isDirty());
		
		Person person2 = new Person();
		System.out.println(((DirtCheckable)person2).isDirty());
		person2.setTemporaryName("Kowalski");
		System.out.println(((DirtCheckable)person2).isDirty());
		person2.setName("Kowalski");
		System.out.println(((DirtCheckable)person2).isDirty());
		
		Company company = new Company();
		System.out.println(((DirtCheckable)company).isDirty());
		company.setAddress("Katowice");
		System.out.println(((DirtCheckable)company).isDirty());
		
	}

}
