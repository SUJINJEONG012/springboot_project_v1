package com.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project1.domain.Product;
import com.project1.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//상품 상세 조회
	@GetMapping("/view/detail")
	public String index(Model model) {
	   	model.addAttribute("template","fragments/content/product/detail");
	   	return "index";
	}
	
	//상품 목록 조회
    @RequestMapping(value = "/view/list/{id}")
	public String viewProductList(@PathVariable Long id, Model model) {
		
    	//data
    	List<Product> productList = productService.getProductList(id);
    	model.addAttribute("productList",productList);
    	
    	//view
    	model.addAttribute("template", "fragments/content/product/list");
    	return "index";
		
	}
  	
}
