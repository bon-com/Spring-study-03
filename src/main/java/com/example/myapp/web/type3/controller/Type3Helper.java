package com.example.myapp.web.type3.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.myapp.web.type1.dto.Prefecture;

/**
 * Type3まわりの画面補助クラス
 * 
 */
@Component
public class Type3Helper {
	/** 都道府県情報 */
	@Value("${prefectures}")
	private String prefecturesStr;
	
	/** 都道府県リスト */
	private List<Prefecture> prefectures = new ArrayList<>();

	/**
	 * 初期化
	 * 
	 */
	@PostConstruct
	public void initBean() {
		// 都道府県リスト作成
		prefectures = Arrays.stream(prefecturesStr.split(",")).map(str -> {
			String[] strArr = str.split(":");
			Prefecture pref = new Prefecture(strArr[0], strArr[1]);
			return pref;
		}).collect(Collectors.toList());
		prefectures.add(0, new Prefecture("", "選択してください"));
	}

	/**
	 * 都道府県名の取得
	 * 
	 * @param prefs
	 * @param prefId
	 * @return
	 */
	public String getPrefName(String prefId) {
		Prefecture result = prefectures.stream().filter(p -> p.getId().equals(prefId)).findFirst().orElse(null);
		if (result == null) {
			// 不正な値のため例外をスロー予定
		}

		return result.getPrefName();
	}

	/**
	 * 都道府県リストの取得
	 * 
	 * @return
	 */
	public List<Prefecture> getPrefectures() {
		return this.prefectures;
	}

}
