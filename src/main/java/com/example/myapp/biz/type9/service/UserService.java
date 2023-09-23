package com.example.myapp.biz.type9.service;

import java.util.List;

import com.example.myapp.dto.type9.UserDTO;
import com.example.myapp.form.type9.UserForm;

public interface UserService {
	List<UserDTO> findAll();
	
	UserDTO findById(int id);
	
	void save(UserForm user);
	
	boolean checkMail(UserForm form);
}
