package com.zensar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class CouponServiceApplication {
	@Value("${test.myLanguage}")
	private String Language;
	@Autowired
	private MyConfig config;

	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}

	@GetMapping("/")
	public String testConfig() {
		return "the language is:"+ Language + "\n your traing is " + config.getTestProperty();

	}
}
