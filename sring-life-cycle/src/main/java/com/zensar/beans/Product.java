package com.zensar.beans;

public class Product {
	private int pId;
	private String pName;
	private int pCost;
	private Product() {
		super();
		System.out.println("Inside Product Bean !!!");
	}
	Product(int pId, String pName, int pCost) {
		super();
		System.out.println("inside Product(int pId, String pName, int pCost)");
		this.pId = pId;
		this.pName = pName;
		this.pCost = pCost;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		//System.out.println(" setpId(int pId)");
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		//System.out.println("setpName(String pName) ");
		this.pName = pName;
	}
	public int getpCost() {
		return pCost;
	}
	public void setpCost(int pCost) {
		//System.out.println("setpCost(int pCost) ");
		this.pCost = pCost;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pAge=" + pCost + "]";
	}
}