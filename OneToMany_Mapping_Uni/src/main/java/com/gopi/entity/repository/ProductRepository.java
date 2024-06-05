package com.gopi.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
