package com.zensar.coupon.service;

import java.util.List;

import com.zensar.coupon.controller.entity.Coupon;
import com.zensar.coupon.dto.CouponDto;

public interface CouponService {
	public CouponDto getCoupon(int CouponId);

	//public List<CouponDto> getCoupons();
	public List<CouponDto> getCoupons(int pageNumber,int pageSize);

	public CouponDto insertCoupon(CouponDto couponDto);

	public void updateCoupon(int CouponId, CouponDto couponDto);

	public void deleteCoupon(int CouponId);

	public List<CouponDto> getByCouponCode(String couponCode);

	public List<CouponDto> getByCouponCodeOrCouponCost(String couponCode, int cost);

	public List<CouponDto> getByCouponCodeAndCouponExDate(String couponCode, String EcouponxDate);

	public List<CouponDto> getByCouponCodeOrderByCouponCost(String couponCode);

}