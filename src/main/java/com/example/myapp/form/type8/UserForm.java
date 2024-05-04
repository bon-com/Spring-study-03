package com.example.myapp.form.type8;

import javax.validation.constraints.NotNull;

import com.example.myapp.form.type7.Type7Form.StudentGroup;

import lombok.Data;

@Data
public class UserForm {
	/** 名前 */
	@NotNull(groups = StudentGroup.class)
	private String name;
	/** 学年 */
	@NotNull(groups = StudentGroup.class)
	private Integer grade;
	/** 学級 */
	@NotNull(groups = StudentGroup.class)
	private String gradeClass;
}
