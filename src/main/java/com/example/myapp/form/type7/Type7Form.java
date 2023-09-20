package com.example.myapp.form.type7;

import javax.validation.Valid;

import com.example.myapp.form.type6.PointForm;
import com.example.myapp.form.type6.UserForm;

import lombok.Data;

@Data
public class Type7Form {
	/** 生徒情報 */
	@Valid
	private UserForm student;
	/** テスト結果 */
	@Valid
	private PointForm result;
}
