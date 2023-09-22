package com.example.myapp.form.type9;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm implements Serializable{
	private Integer id;
	private String name;
	private String email;
	private Date birthday;
	private String prefecture;
	private Date createdAt;
	private Date updatedAt;
}
