package com.rental.car.facade;

import java.util.List;

import com.rental.car.dto.BookingDTO;

public interface BookingFacade {
	
	BookingDTO getBookingDtoById(Long id);
	
	List<BookingDTO> getAllBookings();
	
	BookingDTO createBooking(BookingDTO bookDto) throws Exception;
	
	BookingDTO updateBooking(Long id, BookingDTO bookDto) throws Exception;
	
	String deleteBookingDto(BookingDTO bookingDto) throws Exception;
}
