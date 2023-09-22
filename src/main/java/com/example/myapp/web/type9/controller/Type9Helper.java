package com.example.myapp.web.type9.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.myapp.biz.type9.domain.User;
import com.example.myapp.dto.type9.UserDTO;
import com.example.myapp.web.common.CommonHelper;


@Component
public class Type9Helper {
	@Autowired
	private CommonHelper commonHelper;
	
	public void copyToUserDto(User user, UserDTO userDto) {
		BeanUtils.copyProperties(user, userDto);
		String prefName = commonHelper.getPrefName(userDto.getPrefecture());
		userDto.setPrefName(prefName);
	}
}
