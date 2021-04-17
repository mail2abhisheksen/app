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

public class OrderNotFoundException extends RuntimeException {

	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(String msg) {
		super(msg);
		log.info("Order not found !!");
	}

}
