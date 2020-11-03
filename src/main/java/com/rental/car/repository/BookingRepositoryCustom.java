package com.rental.car.repository;

import java.util.Date;
import java.util.List;

import com.rental.car.model.Booking;
import com.rental.car.model.Car;
import com.rental.car.model.User;

public interface BookingRepositoryCustom {
	
	List<Booking> findBookingExist(Car car, User user, Date dateStart, Date endStart);

	int deleteBookingCustom(Booking booking, User user);
}