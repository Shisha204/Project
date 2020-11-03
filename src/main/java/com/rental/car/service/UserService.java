  
package com.rental.car.service;

import java.util.List;

import com.rental.car.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User getUserById(Long id);
	
	User createUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Long id);

	User getUserByEmail(String email);
}