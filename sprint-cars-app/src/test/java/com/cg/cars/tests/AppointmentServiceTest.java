package com.cg.cars.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cg.cars.exceptions.AppointmentNotFoundException;
import com.cg.cars.exceptions.PaymentNotFoundException;
import com.cg.cars.models.Address;
import com.cg.cars.models.Appointment;
import com.cg.cars.models.Card;
import com.cg.cars.models.Customer;
import com.cg.cars.models.Payment;
import com.cg.cars.repositories.IAppointmentRepository;
import com.cg.cars.services.AppointmentService;
import com.cg.cars.services.CustomerService;
import com.cg.cars.services.PaymentService;

@SpringBootTest
public class AppointmentServiceTest  {
	
	@Autowired
	AppointmentService appointmentService;
	
	
	@MockBean
	IAppointmentRepository appointmentRepository;
	
	Appointment appointment;
	Payment payment;
	Customer customer;
	Address address;
	Card card;
	
	@BeforeEach
	public void init() {
		address = new Address(0,  "string", "string", "string", "string", 0);
		customer = new Customer(2,"string","string","string","string", LocalDate.of(1999, 05, 11), address);
		card = new Card("Anik", "1234567890987654", LocalDate.of(2020, 12, 12), 134);
		payment=new Payment(41, "visa", "pending", card);
		appointment = new Appointment(1, "string", "string", LocalDate.of(2021, 11, 11), LocalTime.of(12, 20, 20), customer, payment);
	}
	
	
	
	  @Test public void addAppointmentTest() {
		  
      when(appointmentRepository.save(appointment)).thenReturn(appointment);
	  assertEquals(appointment, appointmentService.addAppointment(appointment));
	  verify(appointmentRepository,times(1)).save(appointment); }
	 
	
	@Test
	public void getAllAppointmentTest() {
		Appointment appointment1=new Appointment(2, "string", "string", LocalDate.of(2023, 04, 12), LocalTime.of(12, 10, 11), customer, payment);
		Appointment appointment2=new Appointment(3, "string", "string", LocalDate.of(2024, 03, 11), LocalTime.of(10, 25, 25), customer, payment);
		
		List<Appointment> appointments=new ArrayList<>();
		appointments.add(appointment1);
		appointments.add(appointment2);
		
		when(appointmentRepository.findAll()).thenReturn(Stream
				.of(appointment1,appointment2).collect(Collectors.toList()));
		assertEquals(appointments, appointmentService.getAllAppointments());
		verify(appointmentRepository,times(1)).findAll();
	}
	
	@Test
	public void getAppointmentByIdTest() {
		when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));
		assertEquals(appointment, appointmentService.getAppointment(1L));
		verify(appointmentRepository,times(1)).findById(1L);
	}
	
	@Test
	public void getAppointmentByIdNegativeTest() {
		when(appointmentRepository.findById(2L)).thenThrow(AppointmentNotFoundException.class);
		assertThrows(AppointmentNotFoundException.class, () -> appointmentService.getAppointment(2L));
		verify(appointmentRepository,times(1)).findById(2L);
	}
	
	@Test
	public void deleteAppointmentByIdTest() {
		when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));
		when(appointmentRepository.existsById(1L)).thenReturn(false);
		appointmentService.removeAppointment(1L);
		verify(appointmentRepository,times(1)).deleteById(1L);
		assertFalse(appointmentRepository.existsById(1L));
	}
	
	@Test
	public void deleteAppointmentByIdNegativeTest() {
		when(appointmentRepository.findById(2L)).thenThrow(AppointmentNotFoundException.class);
		assertThrows(AppointmentNotFoundException.class, () -> appointmentService.removeAppointment(2L));
		verify(appointmentRepository,times(0)).deleteById(2L);
		verify(appointmentRepository,times(1)).findById(2L);
	}
	
	@Test
	public void updateAppointmentTest() {
		when(appointmentRepository.save(appointment)).thenReturn(appointment);
		assertEquals(appointment, appointmentService.updateAppointment(1L,appointment));
		verify(appointmentRepository,times(1)).save(appointment);
	}
	
	@Test
	public void getOpenAppointmentsTest() {
		
		Appointment appointment1=new Appointment(2, "string", "open", LocalDate.of(2023, 04, 12), LocalTime.of(12, 10, 11), customer, payment);
		Appointment appointment2=new Appointment(3, "string", "open", LocalDate.of(2024, 03, 11), LocalTime.of(10, 25, 25), customer, payment);
		
		List<Appointment> appointments=new ArrayList<>();
		appointments.add(appointment1);
		appointments.add(appointment2);
		
		when(appointmentRepository.findByInspectionType("open")).thenReturn(Stream
				.of(appointment1,appointment2).collect(Collectors.toList()));
		assertEquals(appointments, appointmentService.getOpenAppointments());
		verify(appointmentRepository,times(1)).findByInspectionType("open");
	}
	
	@AfterEach
	public void tearDown() {
		address=null;
		customer=null;
		card=null;
		payment=null;
		appointment=null;
	}
	
}
