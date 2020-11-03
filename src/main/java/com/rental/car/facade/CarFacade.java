package com.rental.car.facade;

import java.util.List;

import com.rental.car.dto.CarDTO;

public interface CarFacade {

	List<CarDTO> getAllCars();
	
	CarDTO getCarDtoById(Long id);
	
	List<CarDTO> getCarDtoByCategory(Long id);
	
	CarDTO createCar(CarDTO carDto);
	
	CarDTO updateCarDto(Long id, CarDTO carDto) throws Exception;
	
	void deleteCarDto(Long id);

}