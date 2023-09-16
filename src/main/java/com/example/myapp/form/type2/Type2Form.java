package com.example.myapp.form.type2;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class Type2Form implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Size(max=30)
	private String name;
	
	@NotNull
	@Range(min=1, max=120)
	private Integer age;
}

