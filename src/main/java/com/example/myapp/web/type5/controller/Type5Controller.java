package com.example.myapp.web.type5.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.myapp.form.type5.Type5Form;

@Controller
@RequestMapping("type5")
@SessionAttributes("type5Form")
public class Type5Controller {
	@RequestMapping(value = "create_session", method = GET)
	public String createSession(Model model) {
		model.addAttribute("type5Form", new Type5Form());
		return "redirect:input";
	}
	
	@RequestMapping(value="input")
	public String showInput() {
		return "type5/input";
	}
	
	@RequestMapping(value = "input", method = POST, params = "send")
	public String showOutput(@Valid Type5Form form, BindingResult rs, Model model) {
		if (rs.hasErrors()) {
			return "type5/input";
		}
		
		String userType = form.getRoles().stream()
				.map(str -> Typet5Constant.ROLE_MAP.get(str))
				.collect(Collectors.joining(", "));
		
		model.addAttribute("userType", userType);
		return "type5/output";
	}
	
	@RequestMapping(value = "input", method = GET, params = "redo") 
	public String showRedo() {
		return "type5/input";
	}
	
	@RequestMapping(value = "menu", method = GET)
	public String showMenu (SessionStatus session) {
		session.isComplete();
		return "redirect:/";
	}
}
