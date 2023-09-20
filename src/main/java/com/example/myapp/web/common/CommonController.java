package com.example.myapp.web.common;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@Component
@ControllerAdvice("com.example.myapp.web")
public class CommonController {
	/** データバインディング設定 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 文字列の入力フォームの前後余白をトリムする
		// トリム後の空文字はnullに変換する
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
