package com.rental.car.converter;

import java.util.List;

import com.rental.car.dto.RoleDTO;
import com.rental.car.model.Role;

public interface RoleConverter {

	Role convert(RoleDTO roleDto);
	
	List<Role> convertAll(List<RoleDTO> roleDto);
	
	RoleDTO reverseConvert(Role role);
	
	List<RoleDTO> reverseConvertAll(List<Role> role);
}
