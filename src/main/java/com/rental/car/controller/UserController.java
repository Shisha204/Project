package com.rental.car.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rental.car.dto.UserDTO;
import com.rental.car.facade.UserFacade;

import javassist.NotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/users/")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserFacade userFacade;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("list-customers")	
	public List<UserDTO> getAllUsers() {
		return userFacade.getAllUsers();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("list-customers/{id}") 
	public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long id) {
		UserDTO user = userFacade.getUserDtoById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CUSTOMER')")
	@GetMapping("/profile/{email}")
	public ResponseEntity<UserDTO> getUserProfile (@PathVariable(value="email") String email) {
		UserDTO user = userFacade.getUserDtoByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	 
	@PreAuthorize("permitAll")
	@PostMapping("register")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {
		UserDTO user = null;
		try {
			user = userFacade.createUser(userDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('CUSTOMER') || hasRole('ADMIN')")
	@PutMapping
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto) {
		try {
			userFacade.updateUserDto(userDto.getId(), userDto);
			return new ResponseEntity<UserDTO>(HttpStatus.CREATED);
		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('CUSTOMER')")
	@DeleteMapping("delete-customers/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) throws NotFoundException {
		logger.info("User deleted with id: " + id);
		
		UserDTO user = userFacade.getUserDtoById(id);
		
		if(user == null) {
			String MsgErr = String.format("The user was not found", id);
			throw new NotFoundException(MsgErr);
		}
		
		userFacade.deleteUserDto(user.getId());
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "deleted user" + user.getName() + "successfully");
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
	}
}