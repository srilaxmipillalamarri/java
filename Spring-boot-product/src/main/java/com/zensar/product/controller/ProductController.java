package com.zensar.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.product.controller.entity.Product;
import com.zensar.product.dto.ProductDto;
import com.zensar.product.service.ProductService;

@RestController
@RequestMapping(value = "/product-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class ProductController {
	@Autowired
	private ProductService productService;

	// private List<Product> products = new ArrayList<Product>();

	/*
	 * public ProductController() { products.add(new Product(100, "Iphone", 50000,
	 * "02-08-2022")); products.add(new Product(101, "Realme", 20000,
	 * "02-04-2022")); products.add(new Product(102, "Vivo", 30000, "06-08-2022"));
	 * }
	 */

	// @RequestMapping("/products/{productId}")
	// @GetMapping(value="/products/{productId}",produces=
	// {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@GetMapping(value = "/product/{productId}")
	// public Product getProduct(@PathVariable("productId") int productId) {
	// public ProductDto getProduct(@PathVariable("productId") int productId) {
	// System.out.println("productId" + productId);
	/*
	 * for (Product product : products) { if (product.getProductId() == productId) {
	 * return product; }
	 */

	// return productService.getProduct(productId);
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId) {
		return new ResponseEntity<ProductDto>(productService.getProduct(productId), HttpStatus.OK);

	}

	// @RequestMapping(value = { "/products", "/listOfProducts" }, method =
	// RequestMethod.GET)
	// @GetMapping( value= {"/products", "/listOfproducts" },produces=
	// {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@GetMapping(value = { "/products", "/listOfproducts" })
	// public List<Product> getAllProducts() {
	// public List<ProductDto> getAllProducts() {
	// return productService.getAllProducts();
	public ResponseEntity<List<ProductDto>> getAllProducts(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,@RequestParam(value="sortBy",
			required=false,defaultValue="productName")String sortBy,@RequestParam(value="dir",required=false,defaultValue="DESC")Direction dir){
		return new ResponseEntity<List<ProductDto>>(productService.getAllProducts(pageNumber, pageSize,  sortBy,dir),
				HttpStatus.OK);
	}

	// @RequestMapping(value = "/products", method = RequestMethod.POST)
	// @PostMapping(value = "/products",consumes=
	// {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@PostMapping(value = "/products")
	// public void insertProduct(@RequestBody Product product) {
	// products.add(product);
	// public ProductDto insertProduct(@RequestBody ProductDto productDto) {
	// return productService.insertProduct(product);
	public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto productDto) {
		return new ResponseEntity<ProductDto>(productService.insertProduct(productDto), HttpStatus.CREATED);

	}

	// @RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
	// @PutMapping(value = "/product/{productId}",consumes=
	// {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@PutMapping(value = "/product/{productId}")
	// public void updateProduct(@PathVariable("productId") int productId,
	// @RequestBody Product product) {
	/*
	 * Product product1 = getProduct(productId);
	 * product1.setProductId(product.getProductId());
	 * product1.setProductName(product.getProductName());
	 * product1.setProductCost(product.getProductCost());
	 * product1.setProductExp(product.getProductExp());
	 * 
	 * products.add(product1);
	 */
	// productService.updateProduct(productId, product);
	public ResponseEntity<String> updateProduct(@PathVariable("productId") int productId,
			@RequestBody ProductDto productDto) {
		productService.updateProduct(productId, productDto);
		return new ResponseEntity<String>("product updated successfully", HttpStatus.OK);
	}

	// @RequestMapping("/products/{productId}"method=RequestMethod.DELETE)
	// @DeleteMapping(value = "/products/{productId}",consumes=
	// {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@DeleteMapping(value = "/product/{productId}")
	// public void deleteProduct(@PathVariable("productId") int productId) {
	/*
	 * for (int i = 0; i < products.size(); i++) { Product product =
	 * products.get(i); if (product.getProductId() == productId) {
	 * products.remove(product);
	 * 
	 * } }
	 */
	// productService.deleteProduct(productId);
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("product deleted successfully", HttpStatus.OK);

	}

	@GetMapping(value="/products/productName/{productName}")
	public ResponseEntity<List<ProductDto>> getByProductName(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(productService.getByProductName(productName), HttpStatus.OK);

	}
	@GetMapping(value="/products/{productName}/{productCost}")
	public ResponseEntity<List<ProductDto>> getByProductNameOrProductCost(@PathVariable("productName")String productName,@PathVariable("productCost")int productCost){
		return new ResponseEntity<List<ProductDto>>(productService.getByProductNameOrProductCost(productName, productCost),HttpStatus.OK);
}
	@GetMapping(value="/products/{productName}/{productExp}")
	public ResponseEntity<List<ProductDto>> getByProductNameAndProductExp(@PathVariable("productName")String productName,@PathVariable("productExp")String productExp){
		return new ResponseEntity<List<ProductDto>>(productService.getByProductNameAndProductExp(productName, productExp),HttpStatus.OK);
		
	}
	@GetMapping(value="/products/order/{productName}")
	public ResponseEntity<List<ProductDto>> getByProductNameOrderByProductCost(@PathVariable("productName")String productName){
		return new ResponseEntity<List<ProductDto>>(productService.getByProductNameOrderByProductCost(productName),HttpStatus.OK);
}
}

























