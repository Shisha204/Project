package com.rental.car.service;

import java.util.List;

import com.rental.car.model.Category;

public interface CategoryService {

	List<Category> listCategories();
	
	Category getCategoryById(Long id);
	
	void addCategory(Category category);

	Category updateCategory(Category cat);

	void deleteCategory(Long id);
}