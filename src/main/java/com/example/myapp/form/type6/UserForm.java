package com.example.myapp.form.type6;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserForm {
	/** 名前 */
	@NotNull
	private String name;
	/** 学年 */
	@NotNull
	private Integer grade;
	/** 学級 */
	@NotNull
	private String gradeClass;
}
