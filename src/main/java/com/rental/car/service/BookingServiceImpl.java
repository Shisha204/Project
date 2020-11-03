package com.rental.car.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.car.dto.BookingDTO;
import com.rental.car.model.Booking;
import com.rental.car.repository.BookingRepository;

@Transactional
@Service("bookingService")
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public List<Booking> getAllBookings() {
		List<Booking> booking = bookingRepository.findAll();
		return booking;
	}

	@Override
	public Booking getBookingById(Long id) {
		return bookingRepository.getOne(id);
	}

	@Override
	public Booking createBooking(Booking booking1) {
		Booking booking = null;

		if(booking1.getStartBooking()!=null && booking1.getEndOfBooking()!=null) {
			List<Booking> exist = bookingRepository.findBookingExist(booking1.getCar(), booking1.getUser(), booking1.getStartBooking(), booking1.getEndOfBooking());
			
			if(exist.isEmpty()) {
				booking = new Booking(booking1.getStartBooking(), booking1.getEndOfBooking(), booking1.getUser(), booking1.getCar());
				bookingRepository.save(booking);
				System.out.println("Prenotazione registrata con successo");
			}
			else {
				System.out.println("Prenotazione non valida");
			}
		} 
		return booking;
	}
		
	@Override
	public Booking updateBooking(Long id, Booking booking) {
		Booking b = this.getBookingById(id);
		
		if(b!=null) {
			b.setStartBooking(booking.getStartBooking());
			b.setEndOfBooking(booking.getEndOfBooking());
			b.setCar(booking.getCar());
			b.setUser(booking.getUser());
		}
		return bookingRepository.save(b);
	}

	@Override
	public int deleteBooking( Booking book) {
		
		return bookingRepository.deleteByIdBookingAndUserAndStartBookingGreaterThan(book.getIdBooking(), book.getUser(), DateUtils.addDays(new Date(), 2));
	}
	
}
