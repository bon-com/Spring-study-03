package com.example.myapp.web.type1.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.form.type1.Type1Form;
import com.example.myapp.web.type1.dto.Prefecture;

@Controller
@RequestMapping("type1")
public class Type1Controller {

	@Autowired
	@Qualifier("propertyConfigurer")
	private PropertySourcesPlaceholderConfigurer propertyConfigurer;
	
	@Value("${prefectures}")
	private String prefecturesString;

	/**
	 * ModelAttributeアノテーションをつけて値を定義すると
	 * 各コントローラーメソッドが実行する前にModelの中に登録される。
	 * 
	 * @return
	 */
	@ModelAttribute("prefectures")
	public List<Prefecture> getPrefList() {
		// 都道府県プロパティから都道府県リスト取得
		List<Prefecture> prefectures = Arrays.stream(prefecturesString.split(","))
				.map(str -> {
					String[] strArr = str.split(":");
					return new Prefecture(strArr[0], strArr[1]);
				})
				.collect(Collectors.toList());
		prefectures.add(0, new Prefecture("", "選択してください"));
		
		return prefectures;
	}
	
	/**
	 * 入力画面表示
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = GET)
	public String showInput(Model model) {
		model.addAttribute(new Type1Form());
		return "type1/input";
	}
	
	/**
	 * 確認画面表示
	 * 
	 * @param form
	 * @param res
	 * @return
	 */
	@RequestMapping(method = POST)
	public String showOutput(@Valid Type1Form form, BindingResult res) {
		if (res.hasErrors()) {
			return "type1/input";
		}
		
		return "type1/output";
	}
}
