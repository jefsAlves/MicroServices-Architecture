package com.alvesjefs.hruser.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvesjefs.hruser.domain.User;
import com.alvesjefs.hruser.repositories.UserRepository;
import com.alvesjefs.hruser.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Sorry, Object Not Found!"));
	}
}
