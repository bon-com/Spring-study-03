package com.example.myapp.biz.type9.domain;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String name;
	private String email;
	private Date birthday;
	private String prefecture;
	private Date createdAt;
	private Date updatedAt;
	
	@Override
	public String toString() {
		return "ID: " + this.id +
				"\n名前: " + this.name +
				"\nメールアドレス: " + this.email +
				"\n誕生日: " + this.birthday +
				"\n出身県: " + this.prefecture +
				"\n作成日: " + this.createdAt +
				"\n更新日: " + this.updatedAt;
 	}
}
