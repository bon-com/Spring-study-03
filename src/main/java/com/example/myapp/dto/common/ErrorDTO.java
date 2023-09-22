package com.example.myapp.dto.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO implements Serializable {
	private String errorTitle;
	private String errorMsg;
}
