package com.ajay.dao;

import java.util.List;

import com.ajay.bean.Person;

public interface PersonDao {

public void save(Person p);
	
	public List<Person> list();
	
}
