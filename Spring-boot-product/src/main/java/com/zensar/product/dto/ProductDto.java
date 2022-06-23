package com.zensar.product.dto;

public class ProductDto {
	private int productId;
	private String productName;
	private int productCost;
	private String productExp;
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
	public String getProductExp() {
		return productExp;
	}
	public void setProductExp(String productExp) {
		this.productExp = productExp;
	}
	private ProductDto(int productId, String productName, int productCost, String productExp) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.productExDate = productExp;
	}
	public ProductDto() {
		super();
	}
	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productExp=" + productExp + "]";
	}
}
