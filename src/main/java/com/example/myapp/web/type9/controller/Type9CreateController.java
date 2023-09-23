package com.example.myapp.web.type9.controller;

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

import com.example.myapp.biz.type9.service.UserService;
import com.example.myapp.form.type9.UserForm;
import com.example.myapp.web.common.CommonHelper;
import com.example.myapp.web.type1.dto.Prefecture;

@Controller
@RequestMapping("type9/user/")
@SessionAttributes("createUserForm")
public class Type9CreateController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommonHelper commonHelper;
	
	@ModelAttribute("prefectures")
	public List<Prefecture> prefectures () {
		return commonHelper.getPrefList();
	}
	
	// 登録画面表示前のフォーム設定
	@RequestMapping(value = "create", method = GET)
	public String setSession(Model model) {
		// フォームをセッション登録して登録画面表示処理へリダイレクト
		model.addAttribute("createUserForm", new UserForm());
		return "redirect:create-user";
	}
	
	// 登録画面表示
	@RequestMapping(value = "create-user", method = GET)
	public String showCreate() {
		return "type9/create/input";
	}
	
	// 登録画面の登録依頼処理
	@RequestMapping(value = "create-user", method = POST, params = "register-request")
	public String registerReq(@Valid @ModelAttribute("createUserForm") UserForm form, BindingResult rs) {
		// 入力値検証
		if (rs.hasErrors()) {
			return "type9/create/input";
		}
		// メールアドレス一意確認
		boolean res = userService.checkMail(form);
		if (!res) {
			rs.rejectValue("email", "error.email", "既に登録されているメールアドレスです。");
			return "type9/create/input";
		}
		
		return "redirect:confirm-user";
	}
	
	// 確認画面表示
	@RequestMapping(value = "confirm-user", method = GET)
	public String showConfirm(@ModelAttribute("createUserForm") UserForm form, Model model) {
		String prefName = commonHelper.getPrefName(form.getPrefecture());
		model.addAttribute("prefName", prefName);
		return "type9/create/confirm";
	}
	
	// DB登録処理
	@RequestMapping(value = "register-user", method = GET)
	public String registUser(@ModelAttribute("createUserForm") UserForm form, BindingResult rs) {
		userService.save(form);
		return "redirect:register-user-complete";
	}
	
	// 完了画面表示
	@RequestMapping(value = "register-user-complete", method = GET)
	public String showComplete(SessionStatus session, @ModelAttribute("createUserForm") UserForm form, Model model) {
		session.isComplete();
		String prefName = commonHelper.getPrefName(form.getPrefecture());
		model.addAttribute("prefName", prefName);
		return "type9/create/complete";
	}
	
	// 登録画面から出る（戻る）
	@RequestMapping(value = "back-action", method = GET)
	public String redo(SessionStatus session) {
		session.isComplete();
		return "redirect:/type9/user";
	}
}
