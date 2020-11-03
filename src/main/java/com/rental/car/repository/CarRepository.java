package com.rental.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rental.car.model.Car;

@Repository("carRepository")
public interface CarRepository extends JpaRepository<Car, Long> { //, CarRepositoryCustom {

	@Query("SELECT c from Car c inner join c.category ca where ca.idCategory=:category")
	List<Car> getCarByCategory(@Param("category") Long idCategory);
}
