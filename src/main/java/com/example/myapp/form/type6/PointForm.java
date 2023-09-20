package com.example.myapp.form.type6;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PointForm {
	/** 国語 */
	@NotNull
	private Integer japaneseLang; // int型にしてしまうと、初期値テキストボックスに0が設定されるので注意
	/** 算数 */
	@NotNull
	private Integer arithmetic;
}
