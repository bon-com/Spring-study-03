package com.example.myapp.biz.type9.repository;

import java.util.List;

import com.example.myapp.biz.type9.domain.User;

public interface UserDao {
	List<User> findAll();
	
	User findById(int id);
}
