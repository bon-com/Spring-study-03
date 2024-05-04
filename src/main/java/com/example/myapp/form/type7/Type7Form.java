package com.example.myapp.form.type7;

import javax.validation.Valid;
import javax.validation.groups.Default;

import lombok.Data;

@Data
public class Type7Form {
	public interface StudentGroup extends Default {}
	public interface PointGruop extends Default {}
	
	/** 生徒情報 */
	@Valid
	private UserForm student;
	/** テスト結果 */
	@Valid
	private PointForm result;
	
	public boolean isNullField() {
		if (student == null) {
			return true;
		} 
		if (result == null) {
			return true;
		}
		if (student.isNullField()) {
			return true;
		}
		if (result.isNullField() ) {
			return true;
		}
		// すべてのフィールドが入力済み
		return false;
	}
}
