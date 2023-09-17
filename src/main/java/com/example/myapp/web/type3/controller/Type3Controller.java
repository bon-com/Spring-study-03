package com.example.myapp.web.type3.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.biz.type3.domain.Customer;
import com.example.myapp.biz.type3.service.CustomerService;

/**
 * 顧客情報参照クラス
 * 
 */
@RequestMapping("type3")
@Controller
public class Type3Controller {
	/** 顧客制御サービスクラス */
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 顧客情報一覧画面の表示
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="home", method = GET)
	public String showAllCustomer(Model model) {
		// 顧客情報一覧を取得
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		
		return "type3/home";
	}
}
