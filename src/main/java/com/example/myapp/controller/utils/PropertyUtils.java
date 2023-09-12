package com.example.myapp.controller.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class PropertyUtils {

	@Autowired
	private MessageSource messageSource;
	
	/**
	 * 単一キーによるメッセージ取得
	 * 
	 * @param key
	 * @return
	 */
	public String getMessage(String key) {
		return getMessage(key, new String[] {});
	}
	
	/**
	 * 
	 * @param key
	 * @param args
	 * @return
	 */
	public String getMessage(String key, Object[] args) {
		return messageSource.getMessage(key, args, Locale.JAPANESE);
	}
}