<<<<<<< HEAD
package com.zensar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	// http://localhost:8080/
	@RequestMapping("/")
	public String sayHello() {
		return "<h2> Welcome to Spring Boot </h2>";
	}
}
=======
package com.zensar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	// http://localhost:8080/
	@RequestMapping("/")
	public String sayHello() {
		return "<h2> Welcome to Spring Boot </h2>";
	}
}
>>>>>>> branch 'main' of https://github.com/srilaxmipillalamarri/java.git
