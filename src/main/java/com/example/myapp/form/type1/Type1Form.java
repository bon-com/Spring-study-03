package com.example.myapp.form.type1;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.myapp.web.type1.validation.AlphaNumeric;
import com.example.myapp.web.type1.validation.NumberRange;

import lombok.Data;

@Data
public class Type1Form implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Size(min = 1, max = 20)
	private String name;
	
	@NotEmpty
	@AlphaNumeric
	private String registerCode;
	
	@NotNull
	@NumberRange(min = 1, max = 10000)
	private Integer pocketMoney;
	
	@NotEmpty
	@Pattern(regexp = "^[0-9]+$")
	private String registerYear;

	@NotEmpty
	@Email
	private String email;
	
	private Boolean newsletter;

	@NotEmpty
	private String gender;

	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd") // これのおかげで画面側の文字列をDateに変換してくれる
	private Date birthdate;

	@NotEmpty
	private String prefecture;

	@NotEmpty
	@Size(min = 3, max = 3)
	private String postalCode1;

	@NotEmpty
	@Size(min = 4, max = 4)
	private String postalCode2;
}
