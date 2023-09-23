package com.example.myapp.biz.type9.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.biz.type9.domain.User;
import com.example.myapp.biz.type9.repository.JdbcUserDao;
import com.example.myapp.common.Constant;
import com.example.myapp.dto.type9.UserDTO;
import com.example.myapp.errors.MyAppDataAccessException;
import com.example.myapp.form.type9.UserForm;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private JdbcUserDao userDao;
	
	@Override
	public List<UserDTO> findAll() {
		// 全検索
		List<User> users = userDao.findAll();
		// ドメインからdtoへコピー
		List<UserDTO> usersDto = users.stream()
				.map(u -> {
					UserDTO dto = new UserDTO();
					BeanUtils.copyProperties(u, dto);
					return dto;
				}).collect(Collectors.toList());
		
		return usersDto;
	}

	@Override
	public UserDTO findById(int id) {
		// ID検索
		User user = userDao.findById(id);
		// ドメインからdtoへコピー
		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(user, userDto);
		
		return userDto;
	}

	@Override
	public void save(UserForm form) {
		// dtoからドメインへコピー
		User user = new User();
		BeanUtils.copyProperties(form, user);
		// 登録失敗時は原因特定が難しいので一旦例外画面へ
		int result = userDao.save(user);
		if (result == Constant.ERROR_NUM) {
			throw new MyAppDataAccessException();
		}
	}

	@Override
	public boolean checkMail(UserForm form) {
		boolean isRegistOk = true;
		User user = userDao.findByMail(form.getEmail());
		if (user != null) {
			isRegistOk = false;
		}
		
		return isRegistOk;
	}
	
	

}
