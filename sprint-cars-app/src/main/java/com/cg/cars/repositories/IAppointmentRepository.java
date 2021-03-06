package com.cg.cars.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.cars.models.Appointment;

/**
*
* @author TEAM 2
* MEMBERS:	Abhishek Sen
* 			Prashant Mhaske
*			Rishabh Gupta
* 			Akshay Talekar
*			Nikhil Nichit
*
*/

public interface IAppointmentRepository extends CrudRepository<Appointment, Long> {
	
	public List<Appointment> findByInspectionType(String type);

	/*
	 * public Appointment addAppointment(Appointment appointment); public
	 * Appointment removeAppointment(long id); public Appointment
	 * updateAppointment(long id, Appointment appointment); public Appointment
	 * getAppointment(long id); public List<Appointment> getAllAppointments();
	 * public List<Appointment> getOpenAppointments();
	 */
}
