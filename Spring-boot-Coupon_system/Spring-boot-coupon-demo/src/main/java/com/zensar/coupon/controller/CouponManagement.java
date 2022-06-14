package com.zensar.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.coupon.controller.entity.Coupon;
import com.zensar.coupon.service.CouponService;

@RestController
@RequestMapping("/coupon-api")
public class CouponManagement {

	@Autowired
	private CouponService couponService;

	// http://localhost:8080/coupons/1001 GET
	// @RequestMapping(value = "/coupons/{couponId}",method=RequestMethod.GET)
	@GetMapping(value = "/coupons/{couponId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Coupon getCoupon(@PathVariable("couponId") int couponId) {
		return couponService.getCoupon(couponId);
	}

	// @RequestMapping(value = { "/coupons", "/listOfcouponss"
	// },method=RequestMethod.GET)
	@GetMapping(value = { "/coupons", "/listOfcoupons" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Coupon> getAllcoupons() {
		return couponService.getAllCoupons();
	}

	// @RequestMapping(value="/coupons",method=RequestMethod.POST)
	@PostMapping(value = "/coupons", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void insertCoupons(@RequestBody Coupon coupon) {
		couponService.insertCoupon(coupon);

	}

	// @RequestMapping(value="/coupons/{couponId}",method=RequestMethod.PUT)
	@PutMapping(value = "/coupons/{couponId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void updateCoupon(@PathVariable("couponId") int couponId, @RequestBody Coupon coupon) {
		couponService.updateCoupon(couponId, coupon);
	}

	// http://localhost:8080/coupon-> Delete
	// @RequestMapping(value="/coupons/{couponId}",method=RequestMethod.DELETE)
	@DeleteMapping(value = "/coupons/{couponId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void deleteCoupon(@PathVariable("couponId") int couponId) {
		couponService.deleteCoupon(couponId);
	}
}