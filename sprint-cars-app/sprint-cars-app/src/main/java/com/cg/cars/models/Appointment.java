package com.cg.cars.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;


@Entity
public class Appointment {
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column
	private String location;
	@Column
	private String inspectionType;
	@Column
	private LocalDate preferredDate;
	@Column
	private LocalTime preferredTime;
	
	
	private Customer customer;

	private Payment payment;
	
	public Appointment(long id, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, Customer customer, Payment payment) {
		super();
		Id = id;
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
		this.customer = customer;
		this.payment = payment;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	public LocalDate getPreferredDate() {
		return preferredDate;
	}

	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}

	public LocalTime getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(LocalTime preferredTime) {
		this.preferredTime = preferredTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Appointment [Id=" + Id + ", location=" + location + ", inspectionType=" + inspectionType
				+ ", preferredDate=" + preferredDate + ", preferredTime=" + preferredTime + ", customer=" + customer
				+ ", payment=" + payment + "]";
	}

	

}
