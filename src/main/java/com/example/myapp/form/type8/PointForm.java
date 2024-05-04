package com.example.myapp.form.type8;

import javax.validation.constraints.NotNull;

import com.example.myapp.form.type7.Type7Form.PointGruop;

import lombok.Data;

@Data
public class PointForm {
	/** 国語 */
	@NotNull(groups = PointGruop.class)
	private Integer japaneseLang; // int型にしてしまうと、初期値テキストボックスに0が設定されるので注意
	/** 算数 */
	@NotNull(groups = PointGruop.class)
	private Integer arithmetic;
}
