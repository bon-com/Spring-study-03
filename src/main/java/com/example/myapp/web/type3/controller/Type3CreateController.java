package com.example.myapp.web.type3.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.myapp.biz.type3.service.CustomerService;
import com.example.myapp.form.type3.CustomerForm;
import com.example.myapp.web.type1.dto.Prefecture;

/**
 * 顧客情報登録クラス
 * 
 */
@Controller
@RequestMapping("type3/customer")
@SessionAttributes("createForm")
public class Type3CreateController {
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
	 * 顧客情報新規登録画面の表示
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create")
	public String showCreate(Model model) {
		// 出力値の設定
		model.addAttribute("createForm", new CustomerForm());
		model.addAttribute("prefectures", type3Helper.getPrefectures());

		return "type3/create/create";
	}

	/**
	 * 顧客情報登録画面の入力値確認
	 * 
	 * @param form
	 * @param rs
	 * @return
	 */
	@RequestMapping(value = "/create", method = POST, params = "confirm")
	public String verifyCreate(@Valid @ModelAttribute("createForm") CustomerForm form, BindingResult rs) {
		// 入力値検証
		if (rs.hasErrors()) {
			// エラー有
			return "type3/create/create";
		}

		return "redirect:confirm-new-customer";
	}

	/**
	 * 顧客情報登録確認画面の表示
	 * 
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/confirm-new-customer", method = GET)
	public String showConfirm(Model model, @ModelAttribute("createForm") CustomerForm form) {
		// 都道府県名の設定
		String prefName = type3Helper.getPrefName(form.getPrefecture());
		model.addAttribute("prefName", prefName);

		return "type3/create/confirm";
	}

	/**
	 * 顧客情報登録確認画面から戻る
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = GET, params = "redo")
	public String redo() {
		return "type3/create/create";
	}
	
	/**
	 * 顧客情報の登録
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/confirm-new-customer", method = POST, params = "complete")
	public String saveCustomer(@ModelAttribute("createForm") CustomerForm form) {
		// 顧客情報の新規登録
		customerService.save(form);

		return "redirect:save-complete";
	}

	/**
	 * 顧客情報登録完了画面の表示
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/save-complete", method = GET)
	public String showSaveDone(SessionStatus session, @ModelAttribute("createForm") CustomerForm form, Model model) {
		// 都道府県名の設定
		String prefName = type3Helper.getPrefName(form.getPrefecture());
		model.addAttribute("prefName", prefName);
		// セッション削除
		session.setComplete();

		return "type3/create/complete";
	}
}
