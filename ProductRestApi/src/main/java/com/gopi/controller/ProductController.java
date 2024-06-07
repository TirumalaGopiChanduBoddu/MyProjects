package com.gopi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.entity.Product;
import com.gopi.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/products/save")
	public List<Product> saveProducts(@RequestBody List<Product> prods){
		List<Product> prod  = productService.saveProducts(prods);
		return prod;
	}
	
	@GetMapping("/products/{query}")
	public List<Product> getProducts(@PathVariable String query)  {
		List<Product> prods = productService.searchProducts(query);
		return prods;
	}
}
