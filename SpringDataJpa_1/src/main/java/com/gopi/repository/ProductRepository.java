package com.gopi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gopi.entity.Product;

import jakarta.persistence.NamedNativeQuery;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	//This is the Query method or Finder method
	public Product findBySku(String sku);
	
	//This is the Query method or Finder method
	public Product findBySkuAndName(String sku , String name);
	
	//@Query annotaion -JPQL query with index parameters 
	@Query("select p from Product p  where p.sku =?1 or p.name =?2") 
	public Product findByStockUnitsorName_IndexParam(String sku , String name);
	
	//@Query annotaion -JPQL query with Named parameters
	@Query("select p from Product p where p.sku =:sku or p.name =:name ")
	public Product findByStockUnitsorName_NamedParam(@Param("sku") String sku ,@Param("name") String name);
	
	//@Query annotaion -Native SQL query with index parameters
	@Query(value ="select * from product_tbl p where stock_keeping_units = ?1 or "+ "product_name = ?2 " , nativeQuery = true)
	public Product findByStockUnitsorNameSQL_IndexParam(String sku , String name);
	
	
	//@Query annotaion -Native SQL query with Named parameters
	@Query(value ="select * from product_tbl p where stock_keeping_units = :sku or "+ "product_name =:name " , nativeQuery = true)
	public Product findByStockUnitsorNameSQL_NamedParam(@Param("sku") String sku , @Param("name") String name);
	
	
	//JPQL query using @NamedQuery annotation
	public Product findBySKU(@Param("stockKeepingUnits") String sku);
	
	//Native SQL query using @@NamedNativeQuery annotation
	public Product findByName(String name);
	
	
	
	
	
	
	
	
	
	
	
}
