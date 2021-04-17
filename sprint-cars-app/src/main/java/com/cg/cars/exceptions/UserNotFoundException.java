package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserNotFoundException extends RuntimeException {

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
	
private static final long serialVersionUID = 4352718547264584589L;
	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	public UserNotFoundException(String message) {
		super(message);
		log.info("User not found !!");
	}

}
