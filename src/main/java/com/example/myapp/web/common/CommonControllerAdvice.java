package com.example.myapp.web.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myapp.common.Constant;
import com.example.myapp.dto.common.ErrorDTO;
import com.example.myapp.errors.KaizanException;
import com.example.myapp.utils.PropertyUtils;

@Component
@ControllerAdvice("com.example.myapp.web")
public class CommonControllerAdvice {
	@Autowired
	PropertyUtils propertyUtils;
	
	/** データバインディング設定 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 文字列の入力フォームの前後余白をトリムする
		// トリム後の空文字はnullに変換する
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@ExceptionHandler
	public String handlerKaizanException(KaizanException e, RedirectAttributes  model) {
		ErrorDTO error = propertyUtils.getErrorDto(Constant.KAIZAN_ERROR_KEY);
		model.addFlashAttribute("errorDto", error);
		return  "redirect:/error";
	}
}
