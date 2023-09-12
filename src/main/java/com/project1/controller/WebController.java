package com.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

//	@GetMapping("/")
//	public String main(Model model) {
//		model.addAttribute("template", "fragments/content/main");
//		return "index";
//	}

	@GetMapping("/product")
	public String index(Model model) {
	   	model.addAttribute("template","fragments/content/product");
	   	return "index";
	}
  	
}
