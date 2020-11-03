package com.rental.car.converter;

import java.util.List;

import com.rental.car.dto.BookingDTO;
import com.rental.car.model.Booking;

public interface BookingConverter {

	Booking convert(BookingDTO bookingDto) throws Exception;
	
	List<Booking> convertAll(List<BookingDTO> bookingDto) throws Exception;
	
	BookingDTO reverseConvert(Booking booking);
	
	List<BookingDTO> reverseConvertAll(List<Booking> booking);
}
