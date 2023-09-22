package com.example.myapp.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.dto.common.ErrorDTO;

@Controller
@RequestMapping("error")
public class ErrorController {
	
	@RequestMapping("")
	public String showError(@ModelAttribute("errorDto") ErrorDTO dto, Model model) {
		model.addAttribute("error", dto);
		return "errors/error";
	}
}
