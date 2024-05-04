package com.example.myapp.form.type3;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 顧客フォームクラス
 * 
 */
@Data
@NoArgsConstructor
public class CustomerForm {
	/** ID */
	private Integer id;
	/** 名前 */
	@NotNull
	private String name;
	/** メールアドレス */
	@NotNull
	@Email
	private String email;
	/** 生年月日 */
	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDay;
	/** 好きな数字 */
	@NotNull
	private Integer favoriteNum;
	/** 出身 */
	@NotNull
	private String prefecture;
	
	public CustomerForm(String name, String email, Date birthDay, Integer favoriteNum, String prefecture) {
		this.name = name;
		this.email = email;
		this.birthDay = birthDay;
		this.favoriteNum = favoriteNum;
		this.prefecture = prefecture;
	}
}
