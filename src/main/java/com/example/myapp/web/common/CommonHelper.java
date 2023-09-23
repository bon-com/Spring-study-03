package com.example.myapp.web.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.myapp.errors.KaizanException;
import com.example.myapp.web.type1.dto.Prefecture;

@Component
public class CommonHelper {
	/** 都道府県情報 */
	@Value("${prefectures}")
	private String prefecturesStr = "";
	/** 都道府県マップ */
	private Map<String, String> prefMap = new LinkedHashMap<>();
	/** 都道府県リスト */
	List<Prefecture> prefList = new ArrayList<>();

	@PostConstruct
	public void initbean() {
		// 都道府県マップ
		Arrays.stream(prefecturesStr.split(",")).forEach(str -> {
			String[] strArr = str.split(":");
			prefMap.put(strArr[0], strArr[1]);
		});

		// 都道府県リスト
		for (Map.Entry<String, String> entry : prefMap.entrySet()) {
			Prefecture pref = new Prefecture(entry.getKey(), entry.getValue());
			prefList.add(pref);
		}
		prefList.add(0, new Prefecture("", "選択してください"));
	}

	public List<Prefecture> getPrefList() {
		return prefList;
	}

	public String getPrefName(String prefKey) {
		String prefName = prefMap.get(prefKey);
		if (prefName == null) {
			throw new KaizanException();
		}

		return prefName;
	}
}
