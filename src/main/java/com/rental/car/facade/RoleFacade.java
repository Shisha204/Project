package com.rental.car.facade;

import java.util.List;

import com.rental.car.dto.RoleDTO;

public interface RoleFacade {
	
	RoleDTO createRole(RoleDTO roleDto);
	
	List<RoleDTO> getList();
	
	RoleDTO findRoleById(int idRole);
	
	RoleDTO findRoleByName(String name);
}
