package com.example.myapp.web.welcome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.utils.PropertyUtils;

@Controller
public class WelcomdeController {

	@Autowired
	private PropertyUtils propertyUtils;
	
	@RequestMapping("/welcome")
	public String hello(Model model) {
		String welcomeMsg = propertyUtils.getMessage("welcome.message");
		model.addAttribute("msg", welcomeMsg);
		return "index";
	}
	
	@RequestMapping("/")
	public String welcome() {
		return "forward:/welcome";
	}
}
