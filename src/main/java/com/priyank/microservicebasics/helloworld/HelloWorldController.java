package com.priyank.microservicebasics.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

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
