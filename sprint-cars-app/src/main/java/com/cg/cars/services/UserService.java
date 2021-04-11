package com.cg.cars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.models.User;
import com.cg.cars.repositories.IUserRepository;

@Service
public class UserService implements IUserService
{
	@Autowired
	IUserRepository userRepository;
	
	Boolean isLoggedIn = true;
	

	@Override
	public User signIn(User user) {
		
		
		String password= userRepository.getPassword(user);
		User u = userRepository.findByUserId(user.getUserId());
		
		if(user.getPassword()==password)
		{
			isLoggedIn = true;
		}
		
		else
			
			isLoggedIn = false;
		
		return u;
	}

	@Override
	public User signOut(User user) {
		
		isLoggedIn = false;
		return user;
	}

	@Override
	public User changePassword(long id, User user) {
		
	
		return userRepository.save(user);
	}

}
