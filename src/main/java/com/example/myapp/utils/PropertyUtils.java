package com.example.myapp.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.example.myapp.dto.common.ErrorDTO;

@Component
public class PropertyUtils {
	/** メッセージソース */
	@Autowired
	private MessageSource messageSource;
	
	public ErrorDTO getErrorDto(String key) {
		String[] msgArr = getMessage(key).split(",");
		ErrorDTO error = new ErrorDTO(msgArr[0], msgArr[1]);
		return error;
	}
	
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