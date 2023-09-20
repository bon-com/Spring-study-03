package com.example.myapp.web.type5.controller;

import java.util.HashMap;
import java.util.Map;

public class Typet5Constant {
	/** 一般利用者 */
	public static final String ROLE_USER = "1";
	/** 管理者 */
	public static final String ROLE_Admin = "2";
	/** 承認者 */
	public static final String ROLE_ACCEPTER = "3";
	
	public static final Map<String, String> ROLE_MAP = new HashMap<>();
	
	static {
		ROLE_MAP.put(ROLE_USER, "利用者");
		ROLE_MAP.put(ROLE_Admin, "管理者");
		ROLE_MAP.put(ROLE_ACCEPTER, "承認者");
	}
}
