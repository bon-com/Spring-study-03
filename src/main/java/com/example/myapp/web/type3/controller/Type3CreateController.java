package com.example.myapp.web.type3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.biz.type3.service.CustomerService;

@Controller
@RequestMapping("type3/customer")
public class Type3CreateController {
	@Autowired
	private CustomerService service;
	@Autowired
	private Type3Helper helper;
	@Value("{$prefectures}")
	private String prefecturesStr;
	
}
