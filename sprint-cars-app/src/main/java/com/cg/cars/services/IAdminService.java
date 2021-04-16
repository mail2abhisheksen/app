package com.cg.cars.services;

import java.util.List;

import com.cg.cars.models.Admin;

public interface IAdminService {
	
	public Admin addAdmin(Admin admin);
	public Admin removeAdmin(long userId);
	public Admin updateAdmin(long userId, Admin admin);
	public Admin getAdmin(long userId);
	public List<Admin> getAllAdmins(); 

}
