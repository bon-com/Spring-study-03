package com.example.myapp.web.type5.controller;

import java.util.HashMap;
import java.util.Map;

public class Typet5Constant {
	/** 利用者権限 */
	public static final Map<String, String> ROLE_MAP = new HashMap<>();
	
	static {
		ROLE_MAP.put("1", "利用者");
		ROLE_MAP.put("2", "管理者");
		ROLE_MAP.put("3", "承認者");
	}
}
