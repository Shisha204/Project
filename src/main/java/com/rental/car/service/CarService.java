package com.rental.car.service;

import java.util.List;

import com.rental.car.model.Car;
import com.rental.car.model.Category;

public interface CarService {

	List<Car> getAllCars(); 
	
	Car getCarById(Long id);
	
	List<Car> getCarByCategory(Long id);
	
	Car createCar(Car car);
    
    Car updateCar(Long id, String model, String manufacturer, String license, int year, Category category);
    
    void deleteCar(Long id);

}