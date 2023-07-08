package com.au.qld.justice.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.qld.justice.registration.model.User;
import com.au.qld.justice.registration.repository.RegistrationRepository;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	public void saveRegistration(final User user) {
		registrationRepository.saveAndFlush(user);
	}

	public List<User> getAllRegistrations() {
		return registrationRepository.findAll();
	}

	public List<User> findByKeyword(final String keyword) {
		if (StringUtils.isNotBlank(keyword)) {
			return registrationRepository.findByKeyword(keyword);
		} else {
			return getAllRegistrations();
		}

	}

}
