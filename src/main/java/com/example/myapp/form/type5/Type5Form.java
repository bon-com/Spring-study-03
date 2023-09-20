package com.example.myapp.form.type5;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Type5Form {
	/** チェックボックス単体表示用 */
	private String isAccept;
	@NotNull
	/** チェックボックスリスト表示用 */
	private List<String> roles;
}
