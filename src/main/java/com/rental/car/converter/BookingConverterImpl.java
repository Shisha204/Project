package com.rental.car.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.car.dto.BookingDTO;
import com.rental.car.model.Booking;

@Component("bookingConverter")
public class BookingConverterImpl implements BookingConverter {

	@Autowired
	private CarConverter carConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public Booking convert(BookingDTO bookingDto) throws Exception {
		Booking booking = new Booking();
		Date dateStart = Optional.ofNullable(bookingDto.getStartBooking())
				.map(startBooking-> {
					try {
						return new SimpleDateFormat("dd/MM/yyyy").parse(startBooking);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return null;
				})
				.orElse(null);
		
		Date dateEnd = Optional.ofNullable(bookingDto.getEndOfBooking())
				.map(endBooking-> {
					try {
						return new SimpleDateFormat("dd/MM/yyyy").parse(endBooking);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return null;
				})
				.orElse(null);
		
		booking.setIdBooking(bookingDto.getId());
		booking.setStartBooking(dateStart);
		booking.setEndOfBooking(dateEnd);
		if(bookingDto.getCar()!=null) {
			booking.setCar(carConverter.convert(bookingDto.getCar()));
		}
		if(bookingDto.getUser()!=null) {
			booking.setUser(userConverter.convert(bookingDto.getUser()));
		}
		
		return booking;
	}

	@Override
	public List<Booking> convertAll(List<BookingDTO> bookingDto) throws Exception {
		List<Booking> bookings = new ArrayList<Booking>();
		Iterator<BookingDTO> bookDto = bookingDto.iterator();
		
		while(bookDto.hasNext()) {
			BookingDTO result = bookDto.next();
			bookings.add(this.convert(result));
		}
		return bookings;
	}

	@Override
	public BookingDTO reverseConvert(Booking booking) {
		BookingDTO bookDto = new BookingDTO();
		String dateStart = new SimpleDateFormat("yyyy-MM-dd").format(booking.getStartBooking());
		String dateEnd = new SimpleDateFormat("yyyy-MM-dd").format(booking.getEndOfBooking());
		
		bookDto.setId(booking.getIdBooking());
		bookDto.setStartBooking(dateStart);
		bookDto.setEndOfBooking(dateEnd);
		bookDto.setCar(carConverter.reverseConvert(booking.getCar()));
		bookDto.setUser(userConverter.reverseConvert(booking.getUser()));
		
		return bookDto;
	}

	@Override
	public List<BookingDTO> reverseConvertAll(List<Booking> bookings) {
		List<BookingDTO> bookingDto = new ArrayList<>();
		Iterator<Booking> booking = bookings.iterator();
		
		while(booking.hasNext()) {
			Booking result = booking.next();
			bookingDto.add(this.reverseConvert(result));
		}
		return bookingDto;
	}

}
