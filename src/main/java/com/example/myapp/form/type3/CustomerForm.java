package com.example.myapp.form.type3;

import java.util.Date;

import lombok.Data;

/**
 * 顧客フォームクラス
 * 
 */
@Data
public class CustomerForm {

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
	
	public CustomerForm(String name, String email, Date birthDay, Integer favoriteNum) {
		this.name = name;
		this.email = email;
		this.birthDay = birthDay;
		this.favoriteNum = favoriteNum;
	}
}
