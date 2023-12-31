package com.project1.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
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

    public Map<Category, List<Category>> getCategory() {
        List<Category> menuList = categoryRepository.findAll();

        // Parent
        List<Category> parentMenuList = menuList.stream()
            .filter(category -> category.getIdParent() == CategoryConstant.PARENT_ROOT)
            .collect(Collectors.toList())
            ;

        // Child
        Map<Long, List<Category>> childMenuMap = menuList.stream()
            .filter(category -> category.getIdParent() != CategoryConstant.PARENT_ROOT)
            .collect(Collectors.groupingBy(Category::getIdParent))
            ;

        // TreeMenu
        Map<Category, List<Category>> menuMap = new HashMap<>();
        for(Category parent : parentMenuList){
            Long id = parent.getId();
            List<Category> child = childMenuMap.get(id);
            menuMap.put(parent, child);
        }
        Map<Category, List<Category>> sortedMenuMap = 
            menuMap.entrySet().stream()
            .sorted((e1, e2)-> e1.getKey().getId().compareTo(e2.getKey().getId()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMenuMap;
    }
}
