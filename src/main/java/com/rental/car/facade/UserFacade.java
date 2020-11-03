package com.rental.car.facade;

import java.text.ParseException;
import java.util.List;

import com.rental.car.dto.UserDTO;

public interface UserFacade {
		
	List<UserDTO> getAllUsers();
	
	UserDTO getUserDtoById(Long id);
	
	UserDTO createUser(UserDTO userDto) throws Exception;
	
	UserDTO updateUserDto(Long id, UserDTO userDto) throws ParseException;
	
	void deleteUserDto(Long id);

	UserDTO getUserDtoByEmail(String email);

}