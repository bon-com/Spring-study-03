package com.example.myapp.web.type9.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.myapp.form.type9.UserForm;

@Controller
@RequestMapping("type9/user/")
@SessionAttributes("createForm")
public class Type9CreateController {
	@RequestMapping(value = "create", method = GET)
	public String setSession(Model model) {
		model.addAttribute("createUserForm", new UserForm());
		return "redirect:create-user";
	}
	@RequestMapping(value = "create-user", method = GET)
	public String showCreate() {
		return "type9/create/input";
	}
}
