package com.dbs.demo;

//import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component
@RestController
public class Hello {

//	http://localhost:8082/hello
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello");
		return "Hello world!";
	}

}
