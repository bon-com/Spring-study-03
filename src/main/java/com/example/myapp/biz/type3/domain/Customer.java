package com.example.myapp.biz.type3.domain;

import java.util.Date;

import lombok.Data;

/**
 * 顧客クラス
 * 
 */
@Data
public class Customer {

	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** メールアドレス */
	private String email;
	/** 生年月日 */
	private Date birthDay;
	/** 好きな数字 */
	private Integer favoriteNum;
	/** 出身県 */
	private String prefecture;
}
