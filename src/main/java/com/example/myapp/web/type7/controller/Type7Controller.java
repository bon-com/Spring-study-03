package com.example.myapp.web.type7.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.myapp.form.type7.Type7Form;
import com.example.myapp.utils.PropertyUtils;
import com.example.myapp.web.type7.controller.UserSearchForm.PointGruop;
import com.example.myapp.web.type7.controller.UserSearchForm.StudentGroup;

@Controller
@RequestMapping("type7")
@SessionAttributes("type7Form")
public class Type7Controller {
	@Autowired
	private PropertyUtils propertyUtils;
	
	@RequestMapping(value = "menu", method = GET)
	public String createSession(Model model) {
		model.addAttribute("type7Form", new Type7Form());
		return "redirect:proceed_menu";
	}

	@RequestMapping(value = "proceed_menu")
	public String showMenu() {
		return "type7/menu";
	}

	@RequestMapping(value = "student-info", method = GET)
	public String showStudentForm() {
		return "type7/input_student";
	}

	@RequestMapping(value = "student-info", method = POST, params = "send")
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

	@RequestMapping(value = "test-info", method = POST, params = "send")
	public String sendTestInfo(@Validated(PointGruop.class) @ModelAttribute("type7Form") Type7Form form,
			BindingResult rs) {
		if (rs.hasErrors()) {
			return "type7/input_test";
		}
		return "redirect:proceed_menu";
	}
	
	@RequestMapping(value="proceed_menu", method=RequestMethod.POST, params="send")
	public String send(@Valid @ModelAttribute("type7Form") Type7Form form, BindingResult rs, Model model) {
		if (form.isNullField() || rs.hasErrors()) {
			model.addAttribute("errorMsg", propertyUtils.getMessage("error.minyuryoku"));
			return "type7/menu";
		}
		return "redirect:proceed_menu?confirm";
	}
	
	@RequestMapping(value="proceed_menu", method=RequestMethod.GET, params="confirm")
	public String confirm() {
		return "type7/confirm";
	}
	
	@RequestMapping(value="proceed_menu", method=RequestMethod.POST, params="redo")
	public String redo() {
		return "redirect:proceed_menu";
	}
	
	@RequestMapping(value="proceed_menu", method=RequestMethod.POST, params="regist")
	public String regist(SessionStatus session) {
		session.isComplete();
		return "redirect:proceed_menu?complete";
	}
	
	@RequestMapping(value="proceed_menu", method=RequestMethod.GET, params="complete")
	public String complete() {
		return "type7/complete";
	}
	
	@RequestMapping(value = "clear-session", method = GET)
	public String clearSession(SessionStatus session) {
		session.isComplete();
		return "redirect:/";
	}
}
