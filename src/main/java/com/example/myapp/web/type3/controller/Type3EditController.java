package com.example.myapp.web.type3.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.myapp.biz.type3.domain.Customer;
import com.example.myapp.biz.type3.service.CustomerService;
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
	/** 都道府県情報 */
	@Value("${prefectures}")
	private String prefecturesStr;

	/** 顧客制御サービスクラス */
	@Autowired
	private CustomerService service;

	/** 顧客情報表示補助クラス */
	@Autowired
	private Type3Helper helper;

	/**  */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 文字列の入力フォームの前後余白をトリムする
		// トリム後の空文字はnullに変換する
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/**
	 * 都道府県情報をModelオブジェクトに設定
	 * 
	 * @return
	 */
	@ModelAttribute("prefectures")
	public List<Prefecture> prefectures() {
		// プロパティから都道府県リスト取得
		List<Prefecture> prefs = Arrays.stream(prefecturesStr.split(",")).map(str -> {
			// Prefectureオブジェクトストリーム作成
			String[] prefArr = str.split(":");
			Prefecture pref = new Prefecture(prefArr[0], prefArr[1]);
			return pref;
		}).collect(Collectors.toList());
		// 初期値設定
		prefs.add(0, new Prefecture("", "選択してください"));

		return prefs;
	}

	/**
	 * 顧客情報編集画面の情報取得
	 * 
	 * @param customerId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = GET)
	public String redirectShowEdit(@PathVariable int customerId, Model model) {
		// 顧客データを取得してフォームにセット
		Customer cusomer = service.findById(customerId);
		CustomerForm form = new CustomerForm();
		BeanUtils.copyProperties(cusomer, form);

		// 出力値設定
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
		return "type3/edit";
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
			return "type3/edit";
		}

		return "redirect:confirm-customer";
	}

	/**
	 * 顧客情報確認画面の表示
	 * 
	 * @return
	 */
	@RequestMapping(value = "/confirm-customer", method = GET)
	public String showConfirm(@ModelAttribute("prefectures") List<Prefecture> prefs,
			@ModelAttribute("editForm") CustomerForm form, Model model) {
		// 都道府県名を設定
		String prefName = helper.getPrefName(prefs, form.getPrefecture());
		model.addAttribute("prefName", prefName);

		return "type3/confirm";
	}

	@RequestMapping(value = "/confirm-customer", method = POST, params = "complete")
	public String updateCustomer(@ModelAttribute("editForm") CustomerForm form) {
		// 顧客情報更新
		service.update(form);

		return "redirect:update-complete";
	}

	@RequestMapping(value = "/update-complete", method = GET)
	public String showUpdateDone(SessionStatus session, @ModelAttribute("editForm") CustomerForm form,
			@ModelAttribute("prefectures") List<Prefecture> prefs, Model model) {
		// 都道府県名を設定
		String prefName = helper.getPrefName(prefs, form.getPrefecture());
		model.addAttribute("prefName", prefName);
		// セッション削除
		session.setComplete();

		return "type3/complete";
	}
}
