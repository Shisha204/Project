package com.rental.car.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.car.dto.CarDTO;
import com.rental.car.dto.CategoryDTO;
import com.rental.car.model.Car;
import com.rental.car.model.Category;
import com.rental.car.service.CategoryService;

@Component("carConverter")
public class CarConverterImpl implements CarConverter{

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public Car convert(CarDTO carDto) {
		if(carDto != null ) {
			Category category = categoryService.getCategoryById(carDto.getCategory().getIdCategory());
			Car car = new Car();
			car.setIdCar(carDto.getIdCar());
			car.setCarModel(carDto.getCarModel());
			car.setManufacturer(carDto.getManufacturer());
			car.setCarLicensePlate(carDto.getCarLicensePlate());
			car.setYearOfRegistration(carDto.getYearOfRegistration());
			car.setCategory(category);
			return car;
		}
		return null;
	}

	@Override
	public List<Car> convertAll(List<CarDTO> carDto) {
		List<Car> cars = new ArrayList<Car>();
		Iterator<CarDTO> carDtos = carDto.iterator();
		
		while(carDtos.hasNext()) {
			CarDTO result = carDtos.next();
			cars.add(this.convert(result));
		}
		return cars;
	}

	@Override
	public CarDTO reverseConvert(Car car) {
		Category category = categoryService.getCategoryById(car.getCategory().getIdCategory());
		CategoryDTO categoryDto = categoryConverter.reverseConvert(category);
		
		CarDTO carDto = new CarDTO();
		carDto.setIdCar(car.getIdCar());
		carDto.setCarModel(car.getCarModel());
		carDto.setManufacturer(car.getManufacturer());
		carDto.setCarLicensePlate(car.getCarLicensePlate());
		carDto.setYearOfRegistration(car.getYearOfRegistration());
		carDto.setCategory(categoryDto);
		
		return carDto;
	}

	@Override
	public List<CarDTO> reverseConvertAll(List<Car> cars) {
		List<CarDTO> carDtos = new ArrayList<>();
		Iterator<Car> car = cars.iterator();
		
		while(car.hasNext()) {
			Car result = car.next();
			carDtos.add(this.reverseConvert(result));
		}
		return carDtos;
	}

}