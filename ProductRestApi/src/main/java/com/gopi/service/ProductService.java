package com.gopi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gopi.entity.Product;


public interface ProductService {

	public List<Product> searchProducts(String query);
	
	public List<Product> saveProducts(List<Product> product);
}
