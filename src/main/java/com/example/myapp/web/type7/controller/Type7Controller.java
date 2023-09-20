package com.example.myapp.web.type7.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.myapp.form.type7.Type7Form;
import com.example.myapp.web.type7.controller.UserSearchForm.PointGruop;
import com.example.myapp.web.type7.controller.UserSearchForm.StudentGroup;

@Controller
@RequestMapping("type7")
@SessionAttributes("type7Form")
public class Type7Controller {
	@RequestMapping(value = "menu", method = GET)
	public String showFirstPage(Model model) {
		model.addAttribute("type7Form", new Type7Form());
		return "type7/menu";
	}

	@RequestMapping(value = "student-info", method = GET)
	public String showStudentForm() {
		return "type7/input_student";
	}

	@RequestMapping(value = "student-info", method = POST, params = "info_student")
	public String sendStudentInfo(@Validated(StudentGroup.class) @ModelAttribute("type7Form") Type7Form form,
			BindingResult rs) {
		if (rs.hasErrors()) {
			return "type7/input_student";
		}
		return "redirect:proceed_menu";
	}

	@RequestMapping(value = "test-info", method = GET)
	public String showTestForm() {
		return "type7/input_test";
	}

	@RequestMapping(value = "test-info", method = POST, params = "info_test")
	public String sendTestInfo(@Validated(PointGruop.class) @ModelAttribute("type7Form") Type7Form form,
			BindingResult rs) {
		if (rs.hasErrors()) {
			return "type7/input_test";
		}
		return "redirect:proceed_menu";
	}

	@RequestMapping(value = "proceed_menu")
	public String showMenu() {
		return "type7/menu";
	}

	@RequestMapping(value = "clear-session", method = GET)
	public String clearSession(SessionStatus session) {
		session.isComplete();
		return "redirect:/";
	}
}
