package com.project1.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.constant.CategoryConstant;
import com.project1.domain.Category;
import com.project1.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Map<Category, List<Category>> getCategory(){ 
		List<Category> menuList = categoryRepository.findAll();
		
		//parent
		List<Category> parentMenuList = menuList.stream()
				.filter(category -> category.getIdParent() == CategoryConstant.PARENT_ROOT)
				.collect(Collectors.toList());
		//child
	}
}
