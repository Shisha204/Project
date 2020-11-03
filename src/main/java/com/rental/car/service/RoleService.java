package com.rental.car.service;

import java.util.List;

import com.rental.car.model.Role;

public interface RoleService {

	void addRole(Role role);
	
	List<Role> getList();
	
	Role findRoleById(int idRole);
	
	Role findRoleByName(String name);
}
