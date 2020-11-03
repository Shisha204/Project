package com.rental.car.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rental.car.model.User;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public User findByEmail(String email) {
		User user = entityManager.
				createQuery("SELECT u FROM User u WHERE u.email=:email", User.class)
				.setParameter("email", email).getSingleResult();
		return user;
	}

}
