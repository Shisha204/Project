package com.rental.car.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.car.converter.BookingConverter;
import com.rental.car.dto.BookingDTO;
import com.rental.car.model.Booking;
import com.rental.car.service.BookingService;

@Component("bookingFacade")
public class BookingFacadeImpl implements BookingFacade {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private BookingConverter bookingConverter;
	
	@Override
	public BookingDTO getBookingDtoById(Long id) {
		Booking booking = bookingService.getBookingById(id);
		BookingDTO bookDto = bookingConverter.reverseConvert(booking);
		return bookDto;
	}

	@Override
	public List<BookingDTO> getAllBookings() {
		List<Booking> booking = bookingService.getAllBookings();
		List<BookingDTO> bookingDto = bookingConverter.reverseConvertAll(booking);
		return bookingDto;
	}

	@Override
	public BookingDTO createBooking(BookingDTO bookDto) throws Exception {
		Booking booking = bookingConverter.convert(bookDto);
		
		Booking b = bookingService.createBooking(booking);
		BookingDTO bookingDto = null;

		if(b!=null) {
			bookingDto = bookingConverter.reverseConvert(b);
		}
		return bookingDto;
	}

	@Override
	public BookingDTO updateBooking(Long id, BookingDTO bookDto) throws Exception {
		Booking booking = bookingConverter.convert(bookDto);
		
		booking.getStartBooking();
		booking.getEndOfBooking();
		booking.getUser();
		booking.getCar();
		
		if(booking!=null) {
			booking = bookingService.updateBooking(id, booking);
			bookDto = bookingConverter.reverseConvert(booking);
		}
		return bookDto;
	}

	@Override
	public String deleteBookingDto( BookingDTO bookDto) throws Exception {
		Booking b = bookingConverter.convert(bookDto);
		int result = bookingService.deleteBooking(b);
		if(result > 0 ) {
			return "Prenotazione eliminata";
		}
		else {
			return "nessuna cancellazione effettuata";
		}
	}

}
