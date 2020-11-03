package com.rental.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.rental.car.dto.CarDTO;
import com.rental.car.facade.CarFacade;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/cars/")
public class CarController {

	@Autowired
	private CarFacade carFacade;
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('CUSTOMER')")
	@GetMapping("list-cars")
	public List<CarDTO> getAllCars() {
		return carFacade.getAllCars();
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('CUSTOMER')")
	@GetMapping("list-cars/{id}")
	public ResponseEntity<CarDTO> getCarById(@PathVariable(value="id") Long id) {
		CarDTO car = carFacade.getCarDtoById(id);
		return new ResponseEntity<>(car, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('CUSTOMER')")
	@GetMapping("list-cars/category/{id}")
	public List<CarDTO> getCarByCategory(@PathVariable(value="id") Long idCategory) {
		List<CarDTO> cars = carFacade.getCarDtoByCategory(idCategory);
		return cars;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("register")
	public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDto) {
		CarDTO car = null;
		try {
			car = carFacade.createCar(carDto);
			return new ResponseEntity<>(car, HttpStatus.CREATED);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping
	public ResponseEntity<CarDTO> updateCar(@RequestBody CarDTO carDto) {
		try {
			Long id = carDto.getIdCar();
			carFacade.updateCarDto(id, carDto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("delete-cars/{id}")
	public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long id) {
		carFacade.deleteCarDto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
