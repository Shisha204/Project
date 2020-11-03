package com.rental.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rental.car.model.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query("SELECT r FROM Role r WHERE r.nameRole=:name")
	public Role findByName(@Param("name") String name);
}

