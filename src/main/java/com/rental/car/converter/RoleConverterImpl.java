package com.rental.car.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rental.car.dto.RoleDTO;
import com.rental.car.model.Role;

@Component("roleConverter")
public class RoleConverterImpl implements RoleConverter{

	@Override
	public Role convert(RoleDTO roleDto) {
		Role role = new Role();
		
		role.setIdRole(roleDto.getIdRole());
		role.setNameRole(roleDto.getNameRole());
//		role.setDescription(roleDto.getDescription());
		return null;
	}

	@Override
	public List<Role> convertAll(List<RoleDTO> roleDto) {
		List<Role> roles = new ArrayList<Role>();
		Iterator<RoleDTO> rolesDto = roleDto.iterator();
		
		while(rolesDto.hasNext()) {
			RoleDTO result = rolesDto.next();
			roles.add(this.convert(result));
		}
		return roles;
	}

	@Override
	public RoleDTO reverseConvert(Role role) {
		RoleDTO roleDto = new RoleDTO();
		roleDto.setIdRole(role.getIdRole());
		roleDto.setNameRole(role.getNameRole());
		
		return roleDto;
	}

	@Override
	public List<RoleDTO> reverseConvertAll(List<Role> roles) {
		List<RoleDTO> rolesDto = new ArrayList<>();
		Iterator<Role> role = roles.iterator();
		
		while(role.hasNext()) {
			Role result = role.next();
			rolesDto.add(this.reverseConvert(result));
		}
		return rolesDto;
	}

}
