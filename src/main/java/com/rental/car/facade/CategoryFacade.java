package com.rental.car.facade;

import java.util.List;

import com.rental.car.dto.CategoryDTO;

public interface CategoryFacade {
	
	List<CategoryDTO> getAllCategory();
	
	CategoryDTO getCategoryDtoById(Long id);
	
	CategoryDTO createCategory(CategoryDTO catDto) throws Exception;
	
	CategoryDTO updateCategoryDto(Long id, CategoryDTO catDto) throws Exception;
	
	void deleteCategoryDto(Long id);

}