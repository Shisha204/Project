package com.rental.car.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HomeController {

	@GetMapping("/home")
	public ResponseEntity<?> helloView() {
		System.out.println("ciao");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
