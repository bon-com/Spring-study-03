package com.example.myapp.web.type3.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.biz.type3.domain.Customer;
import com.example.myapp.biz.type3.service.CustomerService;

@RequestMapping("type3")
@Controller
public class Type3Controller {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="home", method = GET)
	public String showAllCustomer(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		
		return "type3/home";
	}
}
