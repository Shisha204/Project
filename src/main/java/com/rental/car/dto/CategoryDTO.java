package com.rental.car.dto;


public class CategoryDTO {

	private Long idCategory;
	private String name;
	private String cars;
	
	public CategoryDTO() {
		
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCars() {
		return cars;
	}

	public void setCars(String cars) {
		this.cars = cars;
	}
	
}