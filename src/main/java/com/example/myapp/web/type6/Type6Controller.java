package com.example.myapp.web.type6;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.myapp.form.type6.Type6Form;

@Controller
@RequestMapping("type6")
@SessionAttributes("type6Form")
public class Type6Controller {
	@RequestMapping(value = "input", method = GET)
	public String showInput(Model model) {
		model.addAttribute("type6Form", new Type6Form());
		return "type6/input";
	}
	
	@RequestMapping(value = "input", method = POST, params = "send")
	public String showOutput(@Valid @ModelAttribute("type6Form") Type6Form form, BindingResult rs) { // セッションに詰められる
		if (rs.hasErrors()) {
			return "type6/input";
		}
		return "type6/output";
	}
	
	@RequestMapping(value = "input", method = GET, params = "redo")
	public String showRedo() {
		return "type6/input";
	}
	
	@RequestMapping(value = "menu", method = GET)
	public String showMenu(SessionStatus session) {
		session.setComplete();
		return "redirect:/";
	}
}
