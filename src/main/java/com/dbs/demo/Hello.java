package com.dbs.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component
@RestController
public class Hello {

	private static final Logger LOG = LoggerFactory.getLogger(Hello.class);

//	http://localhost:8082/hello
	@RequestMapping("/hello")
	public String hello() {
		LOG.info("hello");
		return "Hello world!";
	}

}
