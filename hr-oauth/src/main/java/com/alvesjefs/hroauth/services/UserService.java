package com.alvesjefs.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alvesjefs.hroauth.domain.User;
import com.alvesjefs.hroauth.feignclients.UserFeignClients;
import com.alvesjefs.hroauth.services.exceptions.ObjectNotFoundException;

@Service
public class UserService implements UserDetailsService {

	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClients userFeignClients;

	public User findByEmail(String email) {
		User user = userFeignClients.findByEmail(email).getBody();

		if (user == null) {
			logger.error("NOT EXIST -> " + email);
			throw new ObjectNotFoundException("Sorry, this email not exists!");
		}

		logger.info("EMAIL -> " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userFeignClients.findByEmail(userName).getBody();
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}

		return user;
	}
}
