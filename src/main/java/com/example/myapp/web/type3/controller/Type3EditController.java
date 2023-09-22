package com.example.myapp.web.type3.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.myapp.biz.type3.domain.Customer;
import com.example.myapp.biz.type3.service.CustomerService;
import com.example.myapp.errors.DataNotFoundException;
import com.example.myapp.form.type3.CustomerForm;
import com.example.myapp.web.type1.dto.Prefecture;

/**
 * 顧客情報編集クラス
 * 
 */
@Controller
@RequestMapping("/type3/customer/{customerId}")
@SessionAttributes("editForm")
public class Type3EditController {
	/** 顧客制御サービスクラス */
	@Autowired
	private CustomerService customerService;

	/** 顧客情報表示補助クラス */
	@Autowired
	private Type3Helper type3Helper;

	/** 都道府県リストをModelに設定 */
	@ModelAttribute("prefectures")
	public List<Prefecture> prefectures() {
		return type3Helper.getPrefectures();
	}

	/**
	 * 顧客情報編集画面の情報取得
	 * 
	 * @param customerId
	 * @param model
	 * @throws DataNotFoundException 
	 * @return
	 */
	@RequestMapping(value = "/edit", method = GET)
	public String redirectShowEdit(@PathVariable int customerId, Model model) throws DataNotFoundException {
		// 顧客詳細の取得
		Customer cusomer = customerService.findById(customerId);
		// フォームにセット
		CustomerForm form = new CustomerForm();
		BeanUtils.copyProperties(cusomer, form);

		// 出力値の設定
		model.addAttribute("editForm", form);

		return "redirect:edit-customer";
	}

	/**
	 * 顧客情報編集画面の表示
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit-customer", method = GET)
	public String showEdit() {
		return "type3/edit/edit";
	}

	/**
	 * 顧客情報編集画面の入力値確認
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit-customer", method = POST, params = "confirm")
	public String verifyEdit(@Valid @ModelAttribute("editForm") CustomerForm form, BindingResult rs) {
		// 入力値検証
		if (rs.hasErrors()) {
			// エラー有
			return "type3/edit/edit";
		}

		return "redirect:confirm-customer";
	}

	/**
	 * 顧客情報確認画面の表示
	 * 
	 * @return
	 */
	@RequestMapping(value = "/confirm-customer", method = GET)
	public String showConfirm(@ModelAttribute("editForm") CustomerForm form, Model model) {
		// 都道府県名を設定
		String prefName = type3Helper.getPrefName(form.getPrefecture());
		model.addAttribute("prefName", prefName);

		return "type3/edit/confirm";
	}

	/**
	 * 顧客情報更新
	 * 
	 * @param form
	 * @throws DataNotFoundException 
	 * @return
	 */
	@RequestMapping(value = "/confirm-customer", method = POST, params = "complete")
	public String updateCustomer(@ModelAttribute("editForm") CustomerForm form) throws DataNotFoundException {
		// 顧客情報更新
		customerService.update(form);

		return "redirect:update-complete";
	}

	/**
	 * 更新完了画面の表示
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update-complete", method = GET)
	public String showUpdateDone(SessionStatus session, @ModelAttribute("editForm") CustomerForm form, Model model) {
		// 都道府県名を設定
		String prefName = type3Helper.getPrefName(form.getPrefecture());
		model.addAttribute("prefName", prefName);
		// セッション削除
		session.setComplete();

		return "type3/edit/complete";
	}
}
