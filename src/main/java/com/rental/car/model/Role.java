package com.rental.car.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
	@Column(name="id_role")
	private int idRole;

	@Column(name="description")
	private String description;

	@Column(name="name_role")
	@Enumerated(EnumType.STRING)
	private ERole nameRole;

	@ManyToMany(mappedBy="roles", targetEntity=User.class)
	private List<User> users; 

	public Role() {
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
		
}