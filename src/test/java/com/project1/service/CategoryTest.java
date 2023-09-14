package com.project1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project1.constant.CategoryConstant;
import com.project1.domain.Category;
import com.project1.repository.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryTest {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void injectedComponentsAreNotNull() {
		List<Category> menuList = categoryRepository.findAll();

		// Parent
		List<Category> parentMenuList = menuList.stream()
				.filter(category -> category.getIdParent() == CategoryConstant.PARENT_ROOT)
				.collect(Collectors.toList());

		// Child
		Map<Long, List<Category>> childMenuMap = menuList.stream()
				.filter(category -> category.getIdParent() != CategoryConstant.PARENT_ROOT)
				.collect(Collectors.groupingBy(Category::getIdParent));

		// TreeMenu
		Map<Category, List<Category>> menuMap = new HashMap<>();
		for (Category parent : parentMenuList) {
			Long id = parent.getId();
			List<Category> child = childMenuMap.get(id);
			menuMap.put(parent, child);
		}
		Map<Category, List<Category>> sortedMenuMap = menuMap.entrySet().stream()
				.sorted((e1, e2) -> e1.getKey().getId().compareTo(e2.getKey().getId())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, HashMap::new));

		System.out.println("===============================================================");
		for (Category key : sortedMenuMap.keySet()) {
			System.out.println(key);
			System.out.println(sortedMenuMap.get(key));
		}
		System.out.println("===============================================================");

	}

}
