package com.alvesjefs.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.hruser.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
