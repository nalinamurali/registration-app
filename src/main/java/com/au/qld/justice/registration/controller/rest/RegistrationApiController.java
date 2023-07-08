package com.au.qld.justice.registration.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.qld.justice.registration.model.User;
import com.au.qld.justice.registration.service.RegistrationService;

@RestController
@RequestMapping("/api")
public class RegistrationApiController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/registrations")
	public List<User> getRegistration() {
		return registrationService.getAllRegistrations();
	}

	@PostMapping("/register")
	public ResponseEntity<String> createRegistration(final @Valid @RequestBody User user) {
		try {
			registrationService.saveRegistration(user);
			return new ResponseEntity<>("Registration is Successful", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/search")
	public List<User> searchUsers(@RequestParam String keyword) {
		return registrationService.findByKeyword(keyword);
	}

}
