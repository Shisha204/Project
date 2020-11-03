package com.rental.car.dto;

public class CarDTO {

	private Long idCar;
	private int yearOfRegistration;
	private String manufacturer;
	private String carModel;
	private String carLicensePlate;
	private CategoryDTO category;
	
	public CarDTO() {
	}

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public int getYearOfRegistration() {
		return yearOfRegistration;
	}

	public void setYearOfRegistration(int yearOfRegistration) {
		this.yearOfRegistration = yearOfRegistration;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarLicensePlate() {
		return carLicensePlate;
	}

	public void setCarLicensePlate(String carLicensePlate) {
		this.carLicensePlate = carLicensePlate;
	}
	
	public CategoryDTO getCategory() {
		return category;
	}
	
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
}