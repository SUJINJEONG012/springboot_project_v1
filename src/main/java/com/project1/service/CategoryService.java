package com.project1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.domain.Category;
import com.project1.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Map<Category, List<Category>> getCategory(){ 
		List<Category> menuList = categoryRepository.findAll();
	
	}
}
