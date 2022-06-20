package com.zensar.product.controller.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int productId;
	private String productName;
	private int productCost;
	private String productExDate;
	public Product() {
		super();
	}
	public Product(int productId, String productName, int productCost, String productExDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.productExDate = productExDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	public String getProductExDate() {
		return productExDate;
	}
	public void setProductExDate(String productExDate) {
		this.productExDate = productExDate;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productExDate=" + productExDate + "]";
	}

}
