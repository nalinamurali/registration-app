package com.au.qld.justice.registration.controller.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.au.qld.justice.registration.model.User;
import com.au.qld.justice.registration.service.RegistrationService;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("users", registrationService.getAllRegistrations());
		return "index";
	}

	@RequestMapping("/newuser")
	public String newRegistration(Model model) {
		model.addAttribute("user", new User());
		return "newuser";
	}

	@RequestMapping("/createRegistration")
	public String createRegistration(final @Valid @ModelAttribute User user) {
		registrationService.saveRegistration(user);
		return "redirect:/";
	}

	@RequestMapping("/search")
	public String search(Model model, String keyword) {
		model.addAttribute("users", registrationService.findByKeyword(keyword));
		return "index";
	}

}
