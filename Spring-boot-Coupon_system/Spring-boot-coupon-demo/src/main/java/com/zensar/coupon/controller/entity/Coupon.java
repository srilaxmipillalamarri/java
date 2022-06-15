package com.zensar.coupon.controller.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {
	@Id
	private int couponId;
	private String couponCode;
	private int couponCost;
	private String couponExDate;

	private Coupon() {
		super();
	}

	private Coupon(int couponId, String couponCode, int couponCost,String couponExDate) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.couponCost = couponCost;
		this.couponExDate = couponExDate;
		
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getCouponCost() {
		return couponCost;
	}

	public void setCouponCost(int couponCost) {
		this.couponCost = couponCost;
	}
	public String getCouponExDate() {
		return couponExDate;
	}

	public void setCouponExDate(String couponExDate) {
		this.couponExDate = couponExDate;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", couponCost=" + couponCost + ",couponExDate=" + couponExDate+"]";
	}
}
