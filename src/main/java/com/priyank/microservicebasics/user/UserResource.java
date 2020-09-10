package com.priyank.microservicebasics.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.priyank.microservicebasics.exception.UserNotFoundException;

@RestController
public class UserResource {
	
	@Autowired
	UserDAOService service;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers()
	{
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User retriveUser(@PathVariable int id)
	{
		User user = service.findOne(id);
		if(user != null)
			return user;
		throw new UserNotFoundException("User with id " + id + " not found!");
	}
    
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user)
	{
		User saveduser = service.save(user);
		//return the URI of save user
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("{id}")
				.buildAndExpand(saveduser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
