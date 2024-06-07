package com.gopi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopi.entity.Product;
import com.gopi.repository.ProductRepository;
import com.gopi.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> searchProducts(String query) {
		List<Product>  prods=productRepository.searchProducts(query);
		return prods;
	}


	@Override
	public List<Product> saveProducts(List<Product> products) {
		List<Product>  prods =productRepository.saveAll(products);
		return prods;
	}

	
	
}
