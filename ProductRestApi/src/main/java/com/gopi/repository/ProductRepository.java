package com.gopi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gopi.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p where p.name like CONCAT('%',:search,  '%') "+ " or p.description like CONCAT('%', :search, '%') ")
	List<Product> searchProducts( String search);
	
}
