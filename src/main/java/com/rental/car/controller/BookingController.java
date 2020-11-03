package com.rental.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.car.dto.BookingDTO;
import com.rental.car.facade.BookingFacade;

@RestController
@RequestMapping(value="/bookings")
@CrossOrigin(value= "http://localhost:4200")
public class BookingController {
	
	@Autowired
	private BookingFacade bookingFacade;
	
	@GetMapping("/list-bookings")
	public List<BookingDTO> getAllBookings() {
		List<BookingDTO> bookings = bookingFacade.getAllBookings();
		return bookings;
	}
	
	@GetMapping("/list-bookings/{id}")
	public ResponseEntity<BookingDTO> getBookingById(@PathVariable(value="id") Long id) {
		BookingDTO booking = bookingFacade.getBookingDtoById(id);
		return new ResponseEntity<>(booking, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookDto) {
		BookingDTO booking = null;
		try {
			booking = bookingFacade.createBooking(bookDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(booking==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(booking, HttpStatus.CREATED);
		}
	}

	@PutMapping
	public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDto) {
		try {
			Long id = bookingDto.getId();
			bookingFacade.updateBooking(id, bookingDto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/delete-bookings")
	public ResponseEntity<String> deleteBooking(@RequestBody BookingDTO bookingDto) throws Exception {
		return ResponseEntity.ok(bookingFacade.deleteBookingDto(bookingDto));
	}

	
}
