package com.cg.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.models.User;
import com.cg.cars.services.UserService;

/**
*
* @author TEAM 2
* MEMBERS: Abhishek Sen
* 		   Prashant Mhaske
*          Rishabh Gupta
*          Akshay Talekar
*          Nikhil Nichit
*
*/

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/SignIn/{userId}/{password}")
	public User signIn(@PathVariable ("userId") long userId, @PathVariable ("password") String password)
	{
		return userService.signIn(userId, password);
		
	}
	
	@GetMapping("/SignOut")
	public User signOut(@RequestBody User user)
	{
		
		
		return userService.signOut(user);
	}
	
	
	@PutMapping("/ChangePassword/{id}")
	public User changePassword(@PathVariable ("id") long id, @RequestBody User user) 
	{
		return userService.changePassword(id, user);
	}
}
