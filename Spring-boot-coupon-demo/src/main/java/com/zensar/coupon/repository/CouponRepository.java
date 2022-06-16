package com.zensar.coupon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.coupon.controller.entity.Coupon;
import com.zensar.coupon.dto.CouponDto;


public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	List<Coupon> findByCouponCode(String couponCode);
	List<Coupon> findByCouponCodeOrCouponCost(String couponCode, int cost);
	List<Coupon> findByCouponCodeAndCouponExDate(String couponCode, String exDate);
	List<Coupon> findByCouponCodeOrderByCouponCost(String CouponCode);
	
	//List<Coupon> test( String couponCode);
	//@Query(value = "from Coupon c where c.couponCode=:code")
	@Query(value = "select * from coupon c where c.coupon_code=:code",nativeQuery=true)
	List<Coupon> test(@Param("code") String CouponCode);
	
	//List<Coupon> test1( String couponCode,String couponExDate);
	//@Query(value = "from Coupon c where c.couponCode=:code and c.couponExDate=:date")
	@Query(value = "select * from coupon c where c.coupon_code=:code and c.coupon_ex_date=:date",nativeQuery=true)
	List<Coupon> test1(@Param("code")String couponCode,@Param("date")String couponExpDate);
}
