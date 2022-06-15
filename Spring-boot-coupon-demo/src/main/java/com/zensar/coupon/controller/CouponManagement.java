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
import com.zensar.coupon.dto.CouponDto;
import com.zensar.coupon.service.CouponService;

@RestController
@RequestMapping(value = "/coupon-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class CouponManagement {

	@Autowired
	private CouponService couponService;

	// http://localhost:8080/coupons/1001 GET
	// @RequestMapping(value = "/coupons/{couponId}",method=RequestMethod.GET)
	@GetMapping(value = "/coupons/{couponId}")
	public CouponDto getCoupon(@PathVariable("couponId") int couponId) {
		return couponService.getCoupon(couponId);

	}

	// @RequestMapping(value = { "/coupons", "/listOfcouponss"
	// },method=RequestMethod.GET)
	@GetMapping(value = { "/coupons", "/listOfcoupons" })
	public List<CouponDto> getAllcoupons() {
		return couponService.getAllCoupons();
	}

	
	
	// @RequestMapping(value="/coupons",method=RequestMethod.POST)
	@PostMapping(value = "/coupons")
		
			/* public void insertCoupon(@RequestBody Coupon coupon) { */

			/* public void insertCoupon@RequestBody CouponDto couponDto) { */

			/* public Coupon insertCoupon(@RequestBody CouponDto couponDto) { */

			/* couponService.insertCoupon(couponDto); */


			// System.out.println("HI");
		public CouponDto insertCoupon(@RequestBody CouponDto couponDto) {

			return couponService.insertCoupon(couponDto);
		}


	

	// @RequestMapping(value="/coupons/{couponId}",method=RequestMethod.PUT)
	@PutMapping(value = "/coupons/{couponId}")
	public void updateCoupon(@PathVariable("couponId") int couponId, @RequestBody CouponDto couponDto) {
		couponService.updateCoupon(couponId, couponDto);
		
	}

	
	
	
	
	
	// http://localhost:8080/coupon-> Delete
	// @RequestMapping(value="/coupons/{couponId}",method=RequestMethod.DELETE)
	@DeleteMapping(value = "/coupons/{couponId}")
	public void deleteCoupon(@PathVariable("couponId") int couponId) {
		couponService.deleteCoupon(couponId);
		
	}
}