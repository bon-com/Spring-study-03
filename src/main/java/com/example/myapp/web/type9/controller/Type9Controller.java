package com.example.myapp.web.type9.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.biz.type9.domain.User;
import com.example.myapp.biz.type9.repository.JdbcUserDao;
import com.example.myapp.dto.type9.UserDTO;

@Controller
@RequestMapping("type9")
public class Type9Controller {
	@Autowired
	private JdbcUserDao userDao;
	
	@Autowired
	private Type9Helper type9Helper;
	
	@RequestMapping(value = "user", method = GET)
	public String showMenu() {
		return "type9/menu";
	}
	
	
	@RequestMapping(value = "user/all", method = GET)
	public String showAll(Model model) {
		List<UserDTO> users = userDao.findAll()
		.stream().map(u -> {
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(u, dto);
			return dto;
		})
		.collect(Collectors.toList());
		
		model.addAttribute("users", users);
		
		return "type9/menu";
	}
	
	@RequestMapping(value = "user/{userId}")
	public String showUserById(@PathVariable int userId, Model model) {
		User userData = userDao.findById(userId);
		UserDTO user = new UserDTO();
		type9Helper.getCopyDto(userData, user);
		model.addAttribute("user", user);
		
		return "type9/menu";
	}
}