package com.example.myapp.web.type3.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.biz.type3.domain.Customer;
import com.example.myapp.biz.type3.service.CustomerService;
import com.example.myapp.errors.DataNotFoundException;

/**
 * 顧客情報削除クラス
 * 
 */
@Controller
@RequestMapping("/type3/customer/{customerId}")
public class Type3DeleteController {
	/** 顧客制御サービスクラス */
	@Autowired
	private CustomerService customerService;

	/** 顧客情報表示補助クラス */
	@Autowired
	private Type3Helper type3Helper;
	
	/**
	 * 顧客情報の削除確認
	 * 
	 * @param customerId
	 * @param model
	 * @return
	 * @throws DataNotFoundException
	 */
	@RequestMapping(value = "/delete", method = GET)
	public String confirm(@PathVariable int customerId, Model model) throws DataNotFoundException {
		// 顧客情報の取得
		Customer customer = customerService.findById(customerId);
		String prefName = type3Helper.getPrefName(customer.getPrefecture());
		
		// 出力値の設定
		model.addAttribute("customer", customer);
		model.addAttribute("prefName", prefName);
		
		return "type3/delete/confirm";
	}
	
	/**
	 * 顧客情報の削除実行
	 * 
	 * @param customerId
	 * @param redirectAttr
	 * @return
	 * @throws DataNotFoundException
	 */
	@RequestMapping(value = "/delete-done", method = GET)
	public String delete(@PathVariable int customerId) throws DataNotFoundException {
		customerService.delete(customerId);
		
		return "redirect:delete-complete";
	}
	
	/**
	 * 顧客情報の削除完了
	 * 
	 * @param customerId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete-complete", method = GET)
	public String showDeleteComplete() {
		return "type3/delete/complete";
	}
}
