package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.restclient.CouponRestClient;
import com.zensar.services.ProductService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	//@Autowired
	//private RestTemplate restTemplate;
	@Autowired
	private CouponRestClient restClient;

	@PostMapping("/")
	@Retry(name="productAPI",fallbackMethod = "retryfallback")
	public Product insertProduct(@RequestBody Product product) {

		//ResponseEntity<Coupon> coupon = restTemplate.getForEntity("http://COUPON-SERVICE/coupons/" + product.getCouponCode(), Coupon.class);
		// ResponseEntity<Coupon>
		// coupon=restTemplate.getForEntity("http://localhost:1234/coupons/"+product.getCouponCode(),
		// Coupon.class, uriVariables);
		Coupon coupon=restClient.getCoupon(product.getCouponCode());
		//Coupon couponObject = coupon.getBody();
		product.setPrice(product.getPrice() - coupon.getDiscount());

		return productService.insertProduct(product);
	}
		public Product retryfallback(Throwable t) {
			return new Product();
			
		

	}

}