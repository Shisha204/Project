package com.rental.car.facade;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.car.converter.UserConverter;
import com.rental.car.dto.UserDTO;
import com.rental.car.model.User;
import com.rental.car.service.UserService;

@Component("userFacade")
public class UserFacadeImpl implements UserFacade {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public List<UserDTO> getAllUsers() {
		List<User> user = userService.getAllUsers();
		return userConverter.reverseConvertAll(user);
	}

	@Override
	public UserDTO getUserDtoById(Long id) {
		User user = userService.getUserById(id);
		UserDTO userDto = userConverter.reverseConvert(user);
		return userDto;
	}
	
	@Override
	public UserDTO getUserDtoByEmail(String email) {
		User user = userService.getUserByEmail(email);
		UserDTO userDto = userConverter.reverseConvert(user);
		return userDto;
	}

	@Override
	public UserDTO createUser(UserDTO userDto) throws Exception {
		User user = userConverter.convert(userDto);
		userService.createUser(user);
		return userConverter.reverseConvert(user);
	}

	@Override
	public UserDTO updateUserDto(Long id, UserDTO userDto) throws ParseException {
		User user = userConverter.convert(userDto); 
		
		if(user!=null) {
			//user = userService.updateUser(user);
			userDto = userConverter.reverseConvert(userService.updateUser(user));
		}
		
		return userDto;
	}

	@Override
	public void deleteUserDto(Long id) {
		userService.deleteUser(id);
	}

}