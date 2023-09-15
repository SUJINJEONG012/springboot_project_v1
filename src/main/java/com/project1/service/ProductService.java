package com.project1.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.domain.Product;
import com.project1.dto.ProductDto;
import com.project1.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;
	
	
	// 상세 상세 조회
	public ProductDto getProduct(Long categoryId) {
		ProductDto productDto = modelMapper.map(productRepository.findById(categoryId).get(), ProductDto.class);
		productDto.setDiscountPrice(productDto.getPrice() * (100- productDto.getDiscount()) /100);
		return productDto;
	}
	
	// 상품리스트 조회
	public List<Product> getProductList(Long categoryId){
		return productRepository.findAllByCategoryId(categoryId);
	}
	
}
