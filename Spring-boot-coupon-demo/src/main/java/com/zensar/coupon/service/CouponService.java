package com.zensar.coupon.service;

import java.util.List;

import com.zensar.coupon.controller.entity.Coupon;
import com.zensar.coupon.dto.CouponDto;

public interface CouponService {

	public CouponDto getCoupon(int couponId);

	public List<CouponDto> getAllCoupons();

	//public CouponDto insertCoupon(CouponDto coupon);
	public CouponDto insertCoupon(CouponDto couponDto);
	

	//public CouponDto updateCoupon(int couponId, CouponDto coupon);
	public void updateCoupon(int couponId, CouponDto coupon);
	

	public void deleteCoupon(int couponId);

}