package com.example.myapp.web.type8.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.errors.DataNotFoundException;
import com.example.myapp.form.type8.Type8Form;

@Controller
@RequestMapping("type8")
public class Type8Controller {
	@RequestMapping(value = "menu", method = GET)
	public String showMenu() {
		return "type8/menu";
	}
	
	/**
	 * 500エラー 
	 * サーブレットコンテナにてエラーハンドリングする。
	 * web.xmlにて<error-code>にHTTPステータスと紐づけたエラー画面を記載する。
	 * 
	 * @return
	 * @throws ServletException
	 */
	@RequestMapping(value = "error-type1", method = GET)
	public String showError() throws ServletException {
		throw new ServletException("例外のスロー");
	}
	
	/**
	 * 404エラー
	 * @return
	 */
	@RequestMapping(value = "error-type2", method = GET)
	public String showError2() {
		return "type8/xxx";
	}
	
	/**
	 * デフォルトエラー（web.xmlにてハンドリングしていないステータス）
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "error-type3", method = POST)
	public String showError3(Type8Form form) {
		return "type8/menu";
	}
	
	/**
	 * 例外クラスを指定した例外ハンドリング
	 * 
	 * @param form
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "error-type4", method = GET)
	public String showError4(Type8Form form) throws IOException {
		throw new IOException();
	}
	
	@RequestMapping(value = "error-type5", method = GET)
	public String showError5() throws DataNotFoundException{
		throw new DataNotFoundException();
	}
	
	@RequestMapping(value = "error-type6", method = GET)
	public String showError6() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
}
