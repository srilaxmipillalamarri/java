package com.zensar.product.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.product.controller.entity.Product;
import com.zensar.product.dto.ProductDto;

public interface ProductService {
	public ProductDto getProduct(int productId);

	// public List<ProductDto> getAllProducts();
	// public List<ProductDto> getAllProducts(int pageNumber,int pageSize)
	public List<ProductDto> getAllProducts(int pageNumber, int pageSize, String sortBy, Direction dir);

	// public void insertProduct(Product product);
	public ProductDto insertProduct(ProductDto productDto);

	// public void updateProduct(int productId, Product product);
	public void updateProduct(int productId, ProductDto productDto);

	public void deleteProduct(int productId);
	
	public List<ProductDto> getByProductName(String productName);
	
	public List<ProductDto> getByProductNameAndProductExDate(String productName,String productExDate);
	
	public List<ProductDto> getByProductNameOrProductCost(String productName,int productCost);
	
	public List<ProductDto> getByProductNameOrderByProductCost(String productName);

	

}
