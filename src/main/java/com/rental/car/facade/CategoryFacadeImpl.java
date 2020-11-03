package com.rental.car.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.car.converter.CategoryConverter;
import com.rental.car.dto.CategoryDTO;
import com.rental.car.model.Category;
import com.rental.car.service.CategoryService;

@Component("categoryFacade")
public class CategoryFacadeImpl implements CategoryFacade {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> cat = categoryService.listCategories();
		return categoryConverter.reverseConvertAll(cat);
	}

	@Override
	public CategoryDTO getCategoryDtoById(Long id) {
		Category category = categoryService.getCategoryById(id);
		CategoryDTO categoryDto = categoryConverter.reverseConvert(category);
		return categoryDto;
	}
	
	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) throws Exception {
		Category category = categoryConverter.convert(categoryDto);
		categoryService.addCategory(category);
		return categoryConverter.reverseConvert(category);
	}

	@Override
	public CategoryDTO updateCategoryDto(Long id, CategoryDTO categoryDto) throws Exception {
		Category category = categoryConverter.convert(categoryDto);
		
		if(category!=null) {
			category = categoryService.updateCategory(category);
			categoryDto = categoryConverter.reverseConvert(category);
		}
		return categoryDto;
	}

	@Override
	public void deleteCategoryDto(Long id) {
		categoryService.deleteCategory(id);
	}
	
}