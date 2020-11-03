package com.rental.car.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rental.car.dto.CategoryDTO;
import com.rental.car.model.Category;

@Component("categoryConverter")
public class CategoryConverterImpl implements CategoryConverter {

	@Override
	public Category convert(CategoryDTO catDto) {
		Category cat = new Category();
		
		cat.setIdCategory(catDto.getIdCategory());
		cat.setName(catDto.getName());
		return null;
	}

	@Override
	public List<Category> convertAll(List<CategoryDTO> catDto) {
		List<Category> cats = new ArrayList<Category>();
		Iterator<CategoryDTO> catsDto = catDto.iterator();
		
		while(catsDto.hasNext()) {
			CategoryDTO result = catsDto.next();
			cats.add(this.convert(result));
		}
		return cats;
	}

	@Override
	public CategoryDTO reverseConvert(Category cat) {
		CategoryDTO catDto = new CategoryDTO();
		catDto.setIdCategory(cat.getIdCategory());
		catDto.setName(cat.getName());
		
		return catDto;
	}

	@Override
	public List<CategoryDTO> reverseConvertAll(List<Category> cats) {
		List<CategoryDTO> catsDto = new ArrayList<>();
		Iterator<Category> cat = cats.iterator();
		
		while(cat.hasNext()) {
			Category result = cat.next();
			catsDto.add(this.reverseConvert(result));
		}
		return catsDto;
	}

	
}