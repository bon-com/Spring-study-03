package com.example.myapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.myapp.form.TestForm2;

/**
 * Spring MVCの基礎的な動きをいろいろ試すコントローラー
 * 
 * 
 */
@Controller
@RequestMapping("test2")
@SessionAttributes("testForm2")
public class TestController2 {

	/**
	 * @ModelAttributeを使用することで、
	 * 各コントローラーメソッドが実行される前にModelAttribute("testForm2")を設定できる。
	 * ModelAttribute(XXX)とは、Modelオブジェクトに格納したオブジェクトのこと。
	 * Modelオブジェクトはコントローラーからビュー側へデータ連携するためのオブジェクト。 
	 */
//    @ModelAttribute("testForm2")
//    public TestForm2 setUpForm() {
//        return new TestForm2();
//    }
	
	/**
	 * 入力画面表示
	 * 
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="create", method = RequestMethod.GET, params="form")
	public String form(Model model) {
		// セッションで管理させる
		model.addAttribute(new TestForm2());
		return "iotest2/input";
	}
	
	/**
	 * 確認画面から入力画面に戻る
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping(value="create", method = RequestMethod.POST, params="redo")
	public String redo(TestForm2 form) {
		return "iotest2/input";
	}
	
	/**
	 * 確認画面表示
	 * 
	 * @param form
	 * @param res
	 * @return
	 */
	@RequestMapping(value="create", method = RequestMethod.POST, params="confirm")
	public String confirm(@Valid TestForm2 form, BindingResult res) {
		// 入力値検証
		if(res.hasErrors()) {
			return "iotest2/input";
		}
		
		return "iotest2/confirm";
	}
}
