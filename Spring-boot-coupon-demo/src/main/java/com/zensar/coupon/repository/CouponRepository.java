package com.zensar.coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.coupon.controller.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
