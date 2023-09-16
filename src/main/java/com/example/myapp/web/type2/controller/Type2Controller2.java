package com.example.myapp.web.type2.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.myapp.form.type2.Type2Form;

/**
 * Spring MVCの基礎的な動きをいろいろ試すコントローラー
 * 
 * 
 */
@Controller
@RequestMapping("type2")
@SessionAttributes("type2Form")
public class Type2Controller2 {

	/**
	 * 入力画面表示
	 * URL：myapp/type2/create?form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "create", method = GET, params = "form")
	public String form(Model model) {
		// セッションで管理させる
		model.addAttribute(new Type2Form());
		return "type2/input";
	}

	/**
	 * 確認画面から戻る
	 * URL：myapp/type2/create?redo=
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "create", method = GET, params = "redo")
	public String redo() {
		return "type2/input";
	}

	/**
	 * 確認画面表示
	 * URL：myapp/type2/create
	 * 
	 * @param form
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "create", method = POST, params = "confirm")
	public String confirm(@Valid Type2Form form, BindingResult res) {
		// 入力値検証
		if (res.hasErrors()) {
			return "type2/input";
		}

		return "type2/confirm";
	}

	/**
	 * 完了画面表示
	 * 
	 * URL：myapp/type2/create?complete=
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "create", method = GET, params = "complete")
	public String complete(Type2Form form, SessionStatus session) {
		// セッションに格納されたフォームの値確認
		System.out.println(form);
		// セッションクリア
		session.setComplete();
		return "type2/complete";
	}

}
