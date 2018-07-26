package com.ajay.dao;

import java.util.List;

import com.ajay.bean.User;

public interface UserDao {
public void save(User p);
	
	public List<User> list();
}
