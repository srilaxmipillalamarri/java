package com.zensar.coupon.endpoint.info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.Info.Builder;

public class TotalInfoContributor  implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub
		Map<String, Object> couponDetails = new HashMap<String,Object>();
		couponDetails.put("CreatedBy:", "srilaxmi");
		couponDetails.put("ModifiedOn:","July22nd2022");
		//builder.withDetails(couponDetails);
		builder.withDetail("coupon", couponDetails);
	}

}