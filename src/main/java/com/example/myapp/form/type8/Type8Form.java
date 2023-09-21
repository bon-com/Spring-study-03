package com.example.myapp.form.type8;

import javax.validation.Valid;

import com.example.myapp.form.type6.PointForm;
import com.example.myapp.form.type6.UserForm;

import lombok.Data;

@Data
public class Type8Form {
	/** 生徒情報 */
	@Valid
	private UserForm student;
	/** テスト結果 */
	@Valid
	private PointForm result;
}
