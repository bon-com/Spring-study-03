package com.example.myapp.web.type3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.myapp.web.type1.dto.Prefecture;

@Component
public class Type3Helper {
	/** 都道府県情報 */
	@Value("${prefectures}")
	private String prefecturesStr;
	
	public String getPrefName(List<Prefecture> prefs, String prefId) {
		Prefecture result = prefs.stream()
				.filter(p -> p.getId().equals(prefId)).findFirst().orElse(null);
		if (result == null) {
			// 不正な値のため例外をスロー予定
		}

		return result.getPrefName();
	}

}
