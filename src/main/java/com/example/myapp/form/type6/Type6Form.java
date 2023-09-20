package com.example.myapp.form.type6;

import javax.validation.Valid;

import lombok.Data;

@Data
public class Type6Form {
	/** 生徒情報 */
	@Valid
	private UserForm student;
	/** テスト結果 */
	@Valid
	private PointForm result;
}
