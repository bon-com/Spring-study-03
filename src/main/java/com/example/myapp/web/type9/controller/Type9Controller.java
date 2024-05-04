package com.example.myapp.web.type9.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.biz.type9.dto.UserDTO;
import com.example.myapp.biz.type9.service.UserService;

@Controller
@RequestMapping("type9")
public class Type9Controller {
	@Autowired
	private UserService userService;
	@Autowired
	private Type9Helper type9Helper;
	
	@RequestMapping(value = "user", method = GET)
	public String showMenu() {
		return "type9/menu";
	}
	
	@RequestMapping(value = "user/all", method = GET)
	public String showAll(Model model) {
		// 利用者一覧取得
		List<UserDTO> users = userService.findAll();
		model.addAttribute("users", users);
		
		return "type9/menu";
	}
	
	@RequestMapping(value = "user/{userId}")
	public String showUserById(@PathVariable int userId, Model model) {
		// 利用者をID検索
		UserDTO userDto = userService.findById(userId);
		type9Helper.setPrefNameToUserDTO(userDto);
		model.addAttribute("user", userDto);
		
		return "type9/menu";
	}
}