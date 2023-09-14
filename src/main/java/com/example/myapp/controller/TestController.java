package com.example.myapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.myapp.form.TestForm;

@Controller
@RequestMapping("test")
public class TestController {

//	@ModelAttribute
//	public TestForm setUpForm() {
//		return new TestForm();
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showInput(Model model) {
		TestForm form = new TestForm();
		model.addAttribute(form);
		return "iotest/input";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String showOutput(@Valid TestForm form, BindingResult res) {
		if (res.hasErrors()) {
			return "iotest/input";
		}
		
		return "iotest/output";
	}
}
