package com.example.myapp.biz.type9.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {
	private Integer id;
	private String name;
	private String email;
	private Date birthday;
	private String prefecture;
	private String prefName;
}
