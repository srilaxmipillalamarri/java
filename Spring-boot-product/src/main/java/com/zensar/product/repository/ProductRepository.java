package com.zensar.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.product.controller.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByproductName(String productName);

	List<Product> findByProductNameOrProductCost(String productName, int cost);

	List<Product> findByProductNameAndProductExDate(String productName, String productExDate);

	List<Product> findByProductNameOrderByProductCost(String productName);

//List<Product> test( String productName);
//@Query(value = "from Product p where p.productName=:name")
	@Query(value = "select * from Product p where p.product_name=:name", nativeQuery = true)
	List<Product> test(@Param("name") String productName);

//List<Product> test1( String productName,String productExDate);
//@Query(value = "from Product p where p.productName=:name and p.productExDate=:date")
	@Query(value = "select * from Product p where p.product_name=:name and p.product_ex_date=:ex_date", nativeQuery = true)
	List<Product> test1(@Param("name") String productName, @Param("ex_date") String productExpDate);
}