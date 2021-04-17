package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class InvalidPasswordException extends RuntimeException {

	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	private static final long serialVersionUID = -8189336152470283801L;

	public InvalidPasswordException(String msg) {
		super(msg);
		log.info("Password not found !!");
	}

}
