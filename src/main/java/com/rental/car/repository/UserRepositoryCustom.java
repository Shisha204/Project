package com.rental.car.repository;

import org.springframework.stereotype.Component;

import com.rental.car.model.User;

@Component
public interface UserRepositoryCustom {
	
	User findByEmail(String email);
}
