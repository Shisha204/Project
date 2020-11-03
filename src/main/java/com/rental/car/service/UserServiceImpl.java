package com.rental.car.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rental.car.model.Role;
import com.rental.car.model.User;
import com.rental.car.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User createUser(User user) {
		Role role = roleService.findRoleById(2);
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
		
		user.setName(user.getName());
		user.setSurname(user.getSurname());
		user.setDateOfBirth(user.getDateOfBirth());
		user.setEmail(user.getEmail());
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		return user = userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		User us = this.getUserById(user.getIdUser());
		
		if(user!=null && us!=null) {
			us.setName(user.getName());
			us.setSurname(user.getSurname());
			us.setDateOfBirth(user.getDateOfBirth());
			us.setEmail(user.getEmail());
			us.setPassword(user.getPassword());
		}
		return userRepository.save(us);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}