package com.example.myapp.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.myapp.validation.AlphaNumeric;
import com.example.myapp.validation.NumberRange;

import lombok.Data;

@Data
public class TestForm implements Serializable {

	@NotEmpty
	@Size(max = 30)
	private String name;

	@NotEmpty
	@AlphaNumeric
	private String registerCode;
	
	@NotNull
	@NumberRange(min = 10, max = 70)
	private Integer age;

	private Boolean newsletter;

	@NotEmpty
	private String gender;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String birthdate;

	@NotEmpty
	private String prefecture;

	@NotEmpty
	@Size(min = 3, max = 3)
	private String postalCode1;

	@NotEmpty
	@Size(min = 4, max = 4)
	private String postalCode2;
}
