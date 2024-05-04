package com.example.myapp.web.type9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.myapp.biz.type9.dto.UserDTO;
import com.example.myapp.web.common.CommonHelper;


@Component
public class Type9Helper {
	@Autowired
	private CommonHelper commonHelper;
	
	public void setPrefNameToUserDTO(UserDTO userDto) {
		String prefName = commonHelper.getPrefName(userDto.getPrefecture());
		userDto.setPrefName(prefName);
	}
	
}
