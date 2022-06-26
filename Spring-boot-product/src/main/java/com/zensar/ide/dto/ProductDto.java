package com.zensar.ide.dto;

public class ProductDto {
	private int productId;
	private String productName;
	private int productCost;
	private String expDate;
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
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	private ProductDto(int productId, String productName, int productCost, String expDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.expDate = expDate;
	}
	public ProductDto() {
		super();
	}
	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", expDate=" + expDate + "]";
	}
}
