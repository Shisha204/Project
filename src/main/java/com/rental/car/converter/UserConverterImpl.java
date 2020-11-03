package com.rental.car.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.rental.car.dto.UserDTO;
import com.rental.car.model.User;

@Component("userConverter")
public class UserConverterImpl implements UserConverter {

	@Override
	public User convert(UserDTO userDto) throws ParseException {
		User user = new User();

		user.setIdUser(userDto.getId());
		user.setName(userDto.getName());
		user.setSurname(userDto.getSurname());
		
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		
		Date dateBirth = Optional.ofNullable(userDto.getDate())
				.map(date-> {
					try {
						return new SimpleDateFormat("dd/MM/yyyy").parse(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return null;
				})
				.orElse(null);
		user.setDateOfBirth(dateBirth);
		
		return user;
		
		
	}

	@Override
	public List<User> convertAll(List<UserDTO> userDto) throws Exception {
		List<User> users = new ArrayList<User>();
		Iterator<UserDTO> userDtos = userDto.iterator();
		
		while(userDtos.hasNext()) {
			UserDTO result = userDtos.next();
			users.add(this.convert(result));
		}
		return users;
	}

	@Override
	public UserDTO reverseConvert(User user) {
		UserDTO userDto = new UserDTO();
		
		userDto.setId(user.getIdUser());
		userDto.setName(user.getName());
		userDto.setSurname(user.getSurname());
		userDto.setDate(new SimpleDateFormat("dd/MM/yyyy").format(user.getDateOfBirth()));
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		
		return userDto;
	}

	@Override
	public List<UserDTO> reverseConvertAll(List<User> users) {
		List<UserDTO> userDtos= new ArrayList<>();
		Iterator<User> user = users.iterator();
		
		while (user.hasNext()) {
			User result = user.next();
			userDtos.add(this.reverseConvert(result));
		}
		return userDtos;
	}

}