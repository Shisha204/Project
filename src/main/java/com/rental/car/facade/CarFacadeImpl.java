package com.rental.car.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.car.converter.CarConverter;
import com.rental.car.dto.CarDTO;
import com.rental.car.model.Car;
import com.rental.car.model.Category;
import com.rental.car.service.CarService;

@Component("carFacade")
public class CarFacadeImpl implements CarFacade {

	@Autowired
	private CarService carService;
	
	@Autowired
	private CarConverter carConverter;
	
	@Override
	public List<CarDTO> getAllCars() {
		List<Car> car = carService.getAllCars();
		return carConverter.reverseConvertAll(car);
	}

	@Override
	public CarDTO getCarDtoById(Long id) {
		Car car = carService.getCarById(id);
		CarDTO carDto = carConverter.reverseConvert(car);
		return carDto;
	}

	@Override
	public List<CarDTO> getCarDtoByCategory(Long idCategory) {
		List<Car> car = carService.getCarByCategory(idCategory);
		List<CarDTO> carDto = carConverter.reverseConvertAll(car);
		return carDto;
	}
	
	@Override
	public CarDTO createCar(CarDTO carDto) {
		Car car = carConverter.convert(carDto);
		carService.createCar(car);
		return carConverter.reverseConvert(car);
	}

	@Override
	public CarDTO updateCarDto(Long id, CarDTO carDto) throws Exception {
		Car car = carConverter.convert(carDto);
		
		String model = car.getCarModel();
		String manufacturer = car.getManufacturer();
		int year = car.getYearOfRegistration();
		String license = car.getCarLicensePlate();
		Category category = car.getCategory();
		
		if(car!=null) {
			car = carService.updateCar(id, model, manufacturer, license, year, category);
			carDto = carConverter.reverseConvert(car);
		}
		return carDto;
	}

	@Override
	public void deleteCarDto(Long id) {
		carService.deleteCar(id);
	}

}