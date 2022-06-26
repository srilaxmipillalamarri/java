package com.zensar.ide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.ide.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByproductName(String productName);

	List<Product> findByProductNameOrProductCost(String productName, int cost);

	List<Product> findByProductNameAndExpDate(String productName, String expDate);

	List<Product> findByProductNameOrderByProductCost(String productName);

//List<Product> test( String productName);
//@Query(value = "from Product p where p.productName=:name")
	@Query(value = "select * from Product p where p.product_name=:name", nativeQuery = true)
	List<Product> byName(@Param("name") String productName);

//List<Product> test1( String productName,String expDate);
//@Query(value = "from Product p where p.productName=:name and p.expDate=:date")
	@Query(value = "select * from Product p where p.product_name=:name and p.exp_date=:date", nativeQuery = true)
	List<Product> byNameAndExpDate(@Param("name") String productName, @Param("date") String expDate);
}