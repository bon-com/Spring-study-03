package com.example.myapp.web.type3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * type3コントローラークラスの共通処理
 * 
 */
@Component
@ControllerAdvice("com.example.myapp.web.type3")
public class Type3ControllerAdvice {
	/** データバインディング設定 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 文字列の入力フォームの前後余白をトリムする
		// トリム後の空文字はnullに変換する
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/**
	 * HTTPセッション例外のハンドリング
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler
	public String handlerException(HttpSessionRequiredException e, HttpServletRequest request) {
		// 編集画面にて例外発生の場合
		if (e.getMessage().contains("editForm")) {
			// 編集画面に遷移
			return "redirect:edit";
		} else {
			// 登録画面にて例外発生の場合
			return "redirect:create";
		}
	}
}
