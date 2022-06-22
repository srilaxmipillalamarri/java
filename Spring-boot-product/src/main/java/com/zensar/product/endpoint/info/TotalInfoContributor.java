package com.zensar.product.endpoint.info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;

public class TotalInfoContributor  implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub
		Map<String, Object> productDetails = new HashMap<String,Object>();
		productDetails.put("CreatedBy:", "srilaxmi");
		productDetails.put("ModifiedOn:","July22nd2022");
		//builder.withDetails(productDetails);
		builder.withDetail("product", productDetails);
	}

}
