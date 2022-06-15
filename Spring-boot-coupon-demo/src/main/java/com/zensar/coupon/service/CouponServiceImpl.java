package com.zensar.coupon.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.coupon.controller.entity.Coupon;
import com.zensar.coupon.dto.CouponDto;
import com.zensar.coupon.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CouponServiceImpl() {

	}

	@Override
	/* public Coupon getCoupon(int couponId) { */
	public CouponDto getCoupon(int couponId) {
		Coupon coupon = couponRepository.findById(couponId).get();
		// StudentDto dto =mapToDto(student);

		return modelMapper.map(coupon, CouponDto.class);
		// return dto;

		/*
		 * return couponRepository.findById(CouponId).get(); couponDto dto=new
		 * CouponDto(); dto.setCouponId(coupon.getCouponId());
		 * dto.setCouponCode(coupon.getCouponCode());
		 * dto.setCouponCost(coupon.getCouponCost());
		 * dto.setCouponExDate(coupon.getCouponExdate()); return dto;
		 */

	}

	@Override
	public List<CouponDto> getAllCoupons() {
		/* return couponRepository.findAll(); */

		List<Coupon> listOfCoupons = couponRepository.findAll();
		List<CouponDto> listOfCouponsDto = new ArrayList<CouponDto>();

		for (Coupon coupon : listOfCoupons) {
//listOfStudentsDto.add(mapToDto(student));
			listOfCouponsDto.add(modelMapper.map(coupon, CouponDto.class));
		}
		return listOfCouponsDto;
	}

	@Override
	public CouponDto insertCoupon(CouponDto couponDto) {

		/*
		 * coupon coupon=new Coupon(); 
		 * coupon.setCouponId(student.getCouponId());
		 * coupont.setCouponCode(Coupon.getCouponCode());
		 * coupon.setCouponCost(coupon.getCouponCost());
		 * coupon.setCouponExDate(coupon.getCouponExDate());
		 */

//Student student=mapToEntity(studentDto);
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon insertedCoupon = couponRepository.save(coupon);
//CouponDto mapToDto=mapToDto(insertedCoupon);
		return modelMapper.map(insertedCoupon, CouponDto.class);
//return mapToDto;

		/*couponDto dto=new CouponDto(); 
		 * dto.setCouponId(insertedCoupon.getCouponId());
		 * dto.setCouponCode(insertedCoupon.getCouponCode());
		 * dto.setCouponCost(insertedCoupon.getCouponCost());
		 * dto.setCouponExDate(insertedCoupon.getCouponExDate());
		 */

	}

	@Override
	public void updateCoupon(int couponId, CouponDto couponDto) {
		/*Coupon coupon = new Coupon();
		coupon.setCouponId(couponDto.getCouponId());
		coupon.setCouponCode(couponDto.getCouponCode());
		coupon.setCouponCost(couponDto.getCouponCost());
		coupon.setCouponExDate(couponDto.getCouponExDate());
		couponRepository.save(coupon);*/
		
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		couponRepository.save(coupon);

	}

	

	@Override
	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);
		
		/*
		 * coupon coupon=new Coupon(); 
		 * coupon.setCouponId(student.getCouponId());
		 * coupont.setCouponCode(Coupon.getCouponCode());
		 * coupon.setCouponCost(coupon.getCouponCost());
		 * coupon.setCouponExDate(coupon.getCouponExDate());
		 */

	}

}

