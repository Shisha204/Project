package com.rental.car.dto;

import java.util.List;

import com.rental.car.model.ERole;

public class RoleDTO {

	private int idRole;
	private String description;
	private ERole nameRole;
	private List<UserDTO> users;
	
	public RoleDTO() {
		super();
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ERole getNameRole() {
		return nameRole;
	}

	public void setNameRole(ERole nameRole) {
		this.nameRole = nameRole;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	} 
	
}
