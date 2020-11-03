package com.rental.car.repository;

import org.springframework.stereotype.Repository;

import com.rental.car.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
	
}
