package com.rental.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.car.model.Category;

@Repository("catRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
