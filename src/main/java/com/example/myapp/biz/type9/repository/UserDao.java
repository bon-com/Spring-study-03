package com.example.myapp.biz.type9.repository;

import java.util.List;

import com.example.myapp.biz.type9.domain.User;

public interface UserDao {
	List<User> findAll();
	
	User findById(int id);
	
	int save(User user);
	
	User findByMail(String mail);
	
	int update(User user);
	
	int delete(int id);
}
