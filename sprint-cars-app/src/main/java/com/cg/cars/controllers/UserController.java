package com.cg.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.models.User;
import com.cg.cars.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/SignIn")
	public User signIn(@RequestBody User user)
	{
		return userService.signIn(user);
		
	}
	
	@GetMapping("/SignOut")
	public User signOut(User user)
	{
		return userService.signOut(user);
	}
	
	
	@PutMapping("/Change Password")
	public User changePassword(@RequestBody long id, User user) 
	{
		return userService.changePassword(id, user);
	}
}
