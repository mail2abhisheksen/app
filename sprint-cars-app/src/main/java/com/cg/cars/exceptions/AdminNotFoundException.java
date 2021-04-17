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

public class AdminNotFoundException extends RuntimeException {

	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	private static final long serialVersionUID = 4372259374757753073L;

	public AdminNotFoundException(String message) {
		super(message);
		log.info("Admin not found !!");
	}

}
