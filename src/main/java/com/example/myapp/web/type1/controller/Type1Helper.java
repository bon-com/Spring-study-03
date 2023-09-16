package com.example.myapp.web.type1.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.myapp.web.type1.common.Type1Constant;
import com.example.myapp.web.type1.dto.Prefecture;

@Component
public class Type1Helper {

	/**
	 * 都道府県IDをもとに都道府県名を返却する
	 * 
	 * @param prefId
	 * @param prefectures
	 * @return
	 */
	public String getPrefName(String prefId, List<Prefecture> prefectures) {
		Prefecture prefecture = prefectures.stream()
				.filter(pref -> pref.getId().equals(prefId))
				.findFirst().orElse(null);
		
		String prefName = "";
		if (prefecture != null) {
			prefName = prefecture.getPrefName();
		}
		
		return prefName;
	}
	
	/**
	 * 性別を返却する
	 * 
	 * @param genderId
	 * @return
	 */
	public String getGender(String genderId) {
		String gender = "";
		if (Type1Constant.MALE.equals(genderId)) {
			gender = "男性";
		} else {
			gender = "女性";
		}
		
		return gender;
	}
}
