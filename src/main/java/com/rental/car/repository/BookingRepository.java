package com.rental.car.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.car.model.Booking;
import com.rental.car.model.User;


@Repository("bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {

	int deleteByIdBookingAndUserAndStartBookingGreaterThan(Long bookingId, User user, Date startBooking);
}
