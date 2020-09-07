package com.priyank.microservicebasics;

import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping("/hello-world")
	public String sayHello()
	{
		return "Hello";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloBean sayHelloBean()
	{
		return new HelloBean("Hello World");
	}
	
	@GetMapping("/hello-world-bean/path-var/{message}")
	public HelloBean sayHelloPathVar(@PathVariable String message)
	{
		return new HelloBean(String.format("Hello %s", message));
	}
	
}
