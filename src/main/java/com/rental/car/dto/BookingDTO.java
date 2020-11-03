package com.rental.car.dto;

public class BookingDTO {
	
	private Long id;
	private String startBooking;
	private String endOfBooking;
	private UserDTO user;
	private CarDTO car;
	
	public BookingDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStartBooking() {
		return startBooking;
	}
	
	public void setStartBooking(String startBooking) {
		this.startBooking = startBooking;
	}
	
	public String getEndOfBooking() {
		return endOfBooking;
	}
	
	public void setEndOfBooking(String endOfBooking) {
		this.endOfBooking = endOfBooking;
	}
	
	public UserDTO getUser() {
		return user;
	}
	
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public CarDTO getCar() {
		return car;
	}
	
	public void setCar(CarDTO car) {
		this.car = car;
	}
	
}
