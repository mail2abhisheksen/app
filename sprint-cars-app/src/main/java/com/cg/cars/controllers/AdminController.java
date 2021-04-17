package com.cg.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.models.Admin;
import com.cg.cars.services.AdminService;

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
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/get")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("id") long id) {
		Admin a = adminService.getAdmin(id);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {	//NOSONAR
		Admin a = adminService.addAdmin(admin);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Admin> removeAdmin(@PathVariable("id") long id) {
		Admin a = adminService.removeAdmin(id);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {	//NOSONAR
		Admin a = adminService.updateAdmin(admin.getUserId(), admin);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

}
