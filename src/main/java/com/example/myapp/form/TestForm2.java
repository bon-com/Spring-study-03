package com.example.myapp.form;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class TestForm2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Size(max=30)
	private String name;
	
	@NotNull
	@Min(1)
	@Max(100)
	private Integer age;
}

