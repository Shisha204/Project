package com.rental.car.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.car.converter.RoleConverter;
import com.rental.car.dto.RoleDTO;
import com.rental.car.model.Role;
import com.rental.car.service.RoleService;

@Component("roleFacade")
public class RoleFacadeImpl implements RoleFacade {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleConverter roleConverter;

	@Override
	public RoleDTO createRole(RoleDTO roleDto) {
		Role role = roleConverter.convert(roleDto);
		roleService.addRole(role);
		return roleConverter.reverseConvert(role);
	}

	@Override
	public List<RoleDTO> getList() {
		List<Role> roles = roleService.getList();
		return roleConverter.reverseConvertAll(roles);
	}

	@Override
	public RoleDTO findRoleById(int idRole) {
		Role role = roleService.findRoleById(idRole);
		RoleDTO roleDto = roleConverter.reverseConvert(role);
		return roleDto;
	}

	@Override
	public RoleDTO findRoleByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
