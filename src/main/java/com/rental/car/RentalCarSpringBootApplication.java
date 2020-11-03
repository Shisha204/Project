package com.rental.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.rental.car"})
public class RentalCarSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalCarSpringBootApplication.class, args);
	}

}
