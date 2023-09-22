package com.example.myapp.web.type3.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.biz.type3.domain.Customer;
import com.example.myapp.biz.type3.service.CustomerService;
import com.example.myapp.errors.DataNotFoundException;

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

	/** 顧客情報表示補助クラス */
	@Autowired
	private Type3Helper type3Helper;
	
	/**
	 * 顧客情報一覧画面の表示
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "home", method = GET)
	public String showAllCustomer(Model model) {
		// 顧客情報一覧を取得
		List<Customer> customers = customerService.findAll();
		
		// 出力値の設定
		model.addAttribute("customers", customers);

		return "type3/home";
	}

	/**
	 * 顧客情報詳細画面の表示
	 * 
	 * @param mode
	 * @return
	 * @throws DataNotFoundException 
	 */
	@RequestMapping(value = "/customer/{customerId}")
	public String showDetail(@PathVariable int customerId, Model model) throws DataNotFoundException {
		// 顧客情報の取得
		Customer customer = customerService.findById(customerId);
		String prefName = type3Helper.getPrefName(customer.getPrefecture());
		
		// 出力値の設定
		model.addAttribute("customer", customer);
		model.addAttribute("prefName", prefName);

		return "type3/detail";
	}
}
