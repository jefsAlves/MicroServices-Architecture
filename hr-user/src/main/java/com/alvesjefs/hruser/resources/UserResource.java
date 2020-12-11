package com.alvesjefs.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvesjefs.hruser.domain.User;
import com.alvesjefs.hruser.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User user = userService.findByEmail(email);
		return ResponseEntity.ok().body(user);
	}
}
