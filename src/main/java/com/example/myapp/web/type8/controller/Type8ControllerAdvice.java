package com.example.myapp.web.type8.controller;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice("com.example.myapp.web.type8")
public class Type8ControllerAdvice {
	@ExceptionHandler
	public String handlerException(FileNotFoundException e) {
		return "redirect:/";
	}
}
