<<<<<<< HEAD
package com.zensar.security.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moAuth/rest")
public class NoAuthController {
   @GetMapping("/sayhi")
	public String sayHi() {
		return "Hello authenticator";
	}
}
=======
package com.zensar.security.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moAuth/rest")
public class NoAuthController {
   @GetMapping("/sayhi")
	public String sayHi() {
		return "Hello authenticator";
	}
}
>>>>>>> branch 'main' of https://github.com/srilaxmipillalamarri/java.git
