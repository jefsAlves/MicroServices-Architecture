package com.alvesjefs.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alvesjefs.hroauth.domain.User;

@Component
@FeignClient(name = "hr-user", path = "api/users")
public interface UserFeignClients {

	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);

}
