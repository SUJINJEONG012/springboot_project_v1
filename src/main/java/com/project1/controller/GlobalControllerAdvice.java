package com.project1.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.project1.domain.Category;
import com.project1.service.CategoryService;

@ControllerAdvice
public class GlobalControllerAdvice {

	@Autowired
    private CategoryService categoryService;
    
    @ModelAttribute
	public void handleRequest(HttpServletRequest request, Locale locale, Model model) {
        String servletPath = request.getServletPath();
        
        // view 페이지 호출할 때 메뉴 조립
        if(!servletPath.isEmpty() && 
        (
            servletPath.equals("/") || servletPath.contains("/view/")
            )
        ){
            Map<Category, List<Category>> categoryList = categoryService.getCategory();
            model.addAttribute("categories", categoryList);
        }
    }
	
}
