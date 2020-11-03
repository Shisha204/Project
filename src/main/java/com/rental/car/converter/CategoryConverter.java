package com.rental.car.converter;

import java.util.List;

import com.rental.car.dto.CategoryDTO;
import com.rental.car.model.Category;

public interface CategoryConverter {

	Category convert(CategoryDTO catDto) throws Exception; 
	
	List<Category> convertAll(List<CategoryDTO> catDto) throws Exception;
	
	CategoryDTO reverseConvert(Category cat);
	
	List<CategoryDTO> reverseConvertAll(List<Category> cat);
}
