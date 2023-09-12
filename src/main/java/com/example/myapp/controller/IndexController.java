package com.example.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.controller.utils.PropertyUtils;

@Controller
public class IndexController {

	@Autowired
	private PropertyUtils propertyUtils;
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		String welcomeMsg = propertyUtils.getMessage("welcome.message");
		model.addAttribute("msg", welcomeMsg);
		return "index";
	}
}
