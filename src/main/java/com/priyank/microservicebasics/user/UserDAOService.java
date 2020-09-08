package com.priyank.microservicebasics.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

	private static List<User> usersList = new ArrayList<>();
	private static int counter = 3;
	static {
		usersList.add(new User(1, "Priyank", new Date()));
		usersList.add(new User(2, "Neetu", new Date()));
		usersList.add(new User(3, "Dolly", new Date()));
	}
	
	
	public List<User> findAll()
	{
		return usersList;
	}
	
	public User save(User user)
	{
		if(user.getId() == null)
			user.setId(++counter);
		usersList.add(user);
		return user;
	}
	
	public User findOne(int id)
	{
		for (User user : usersList) {
			if(user.getId() == id)
				return user;
		}
		
		return null;
	}
	
	
}
