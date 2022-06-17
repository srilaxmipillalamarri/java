package com.zensar.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

//	@GetMapping(value = "/coupon/{couponId}",produces = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE })
	@GetMapping(value = "/coupon/{couponId}")
	// public CouponDto getCoupon(@PathVariable("couponId") int CouponId) {
	public ResponseEntity<CouponDto> getCoupon(@PathVariable("couponId") int CouponId) {
		// return couponService.getCoupon(CouponId);
		return new ResponseEntity<CouponDto>(couponService.getCoupon(CouponId), HttpStatus.OK);
	}

//	@GetMapping(value = "/coupons",produces = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE })
	@GetMapping(value = "/coupons/")
	// public List<CouponDto> getCoupons() {
	//public ResponseEntity<List<CouponDto>> getCoupons() {
	public ResponseEntity<List<CouponDto>> getCoupons(@RequestParam(value="pageNumber",required=false,defaultValue="0")int pageNumber,@RequestParam(value="pageSize",required = false,defaultValue = "3")int pageSize,String sortBy,Direction dir) {
		// return couponService.getCoupons();
		return new ResponseEntity<List<CouponDto>>(couponService.getCoupons(pageNumber,pageSize,sortBy,dir), HttpStatus.OK);
	}

//	@PostMapping(value = "/coupons",consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PostMapping(value = "/coupons")
	// public CouponDto insertCoupon(@RequestBody CouponDto couponDto) {
	public ResponseEntity<CouponDto> insertCoupon(@RequestBody CouponDto couponDto) {
		// return couponService.insertCoupon(couponDto);
		return new ResponseEntity<CouponDto>(couponService.insertCoupon(couponDto), HttpStatus.CREATED);
	}

//	@PutMapping(value = "coupons/{couponId}",consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE })
	@PutMapping(value = "coupons/{couponId}")
	// public void updateCoupon(@PathVariable("couponId") int CouponId, @RequestBody
	// CouponDto couponDto) {
	public ResponseEntity<String> updateCoupon(@PathVariable("couponId") int CouponId,
			@RequestBody CouponDto couponDto) {
		couponService.updateCoupon(CouponId, couponDto);
		return new ResponseEntity<String>("Coupon updated Succesfully", HttpStatus.OK);

	}

	@DeleteMapping("coupons/{couponId}")
	// public void deleteCoupon(@PathVariable("couponId") int CouponId) {
	public ResponseEntity<String> deleteCoupon(@PathVariable("couponId") int CouponId) {
		couponService.deleteCoupon(CouponId);
		return new ResponseEntity<String>("Coupon deleted Succesfully", HttpStatus.OK);
	}

	@GetMapping("coupons/code/{couponCode}")
	public ResponseEntity<List<CouponDto>> getByCouponCode(@PathVariable("couponCode") String couponCode) {
		return new ResponseEntity<List<CouponDto>>(couponService.getByCouponCode(couponCode), HttpStatus.OK);
	}

	@GetMapping("coupons/{couponCode}/{couponCost}")
	public ResponseEntity<List<CouponDto>> getByCouponCodeOrCouponCost(@PathVariable("couponCode") String couponCode,
			@PathVariable("couponCost") int couponCost) {
		return new ResponseEntity<List<CouponDto>>(couponService.getByCouponCodeOrCouponCost(couponCode, couponCost),
				HttpStatus.OK);
	}

	@GetMapping("coupons/date/{couponCode}/{couponExDate}")
	public ResponseEntity<List<CouponDto>> getByCouponCodeAndCouponExDate(@PathVariable("couponCode") String couponCode,
			@PathVariable("couponExDate") String couponExDate) {
		return new ResponseEntity<List<CouponDto>>(couponService.getByCouponCodeAndCouponExDate(couponCode, couponExDate),
				HttpStatus.OK);
	}

	@GetMapping("coupons/order/{couponCode}")
	public ResponseEntity<List<CouponDto>> getByCouponCodeOrderByCouponCost(
			@PathVariable("couponCode") String couponCode) {
		return new ResponseEntity<List<CouponDto>>(couponService.getByCouponCodeOrderByCouponCost(couponCode),
				HttpStatus.OK);
	}
}
