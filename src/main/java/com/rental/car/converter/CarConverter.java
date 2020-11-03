package com.rental.car.converter;

import java.util.List;

import com.rental.car.dto.CarDTO;
import com.rental.car.model.Car;

public interface CarConverter {
	
	Car convert(CarDTO carDto);
	
	List<Car> convertAll(List<CarDTO> carDto);
	
	CarDTO reverseConvert(Car car);
	
	List<CarDTO> reverseConvertAll(List<Car> car);
}
