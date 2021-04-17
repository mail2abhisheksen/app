package com.cg.cars.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.exceptions.CustomerNotFoundException;
import com.cg.cars.exceptions.PaymentNotFoundException;
import com.cg.cars.models.Address;
import com.cg.cars.models.Customer;
import com.cg.cars.repositories.ICustomerRepository;
import com.cg.cars.services.CustomerService;


@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerService customerService;

	@MockBean
	ICustomerRepository customerRepository;

	Address address;
	Customer customer;
	
	@BeforeEach
	public void init() {
		address = new Address(345, "datta", "khed", "Pune" , "MH" , 456432);
		customer = new Customer(678 , "jhk" , "Rish" , "abc@g.com" , "7566567688" , LocalDate.of(2020, 11, 15) , address);
	}
	
	@Test
	public void addCustomerTest() {
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerService.addCustomer(customer));
		verify(customerRepository,times(1)).save(customer);
	}
	
	@Test
	public void removeCustomerbyIdTest() {
		when(customerRepository.findById(678L)).thenReturn(Optional.of(customer));
		when(customerRepository.existsById(678L)).thenReturn(false);
		customerService.removeCustomer(678L);
		verify(customerRepository,times(1)).deleteById(678L);
		assertFalse(customerRepository.existsById(678L));
	}
	
	@Test
	public void removeCustomerByIdNegativeTest() {
		when(customerRepository.findById(2L)).thenThrow(CustomerNotFoundException.class);
		assertThrows(CustomerNotFoundException.class, () -> customerService.removeCustomer(2L));
		verify(customerRepository,times(0)).deleteById(2L);
		verify(customerRepository,times(1)).findById(2L);
	}
	
	@Test
	public void updateCustomerTest() {
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerService.updateCustomer(1L,customer));
		verify(customerRepository,times(1)).save(customer);
	}
	
	@Test
	public void updateCustomerNegativeTest() {
		when(customerRepository.save(customer)).thenThrow(CustomerNotFoundException.class);
		assertThrows(CustomerNotFoundException.class, () -> customerService.updateCustomer(3L, customer));
		verify(customerRepository,times(1)).save(customer);
	}
	
	@Test
	public void getCustomerByIdTest() {
		when(customerRepository.findById(678L)).thenReturn(Optional.of(customer));
		assertEquals(customer, customerService.getCustomer(678L));
		verify(customerRepository,times(1)).findById(678L);
	}
	
	@Test
	public void getCustomerByIdNegativetest() {
		
		when(customerRepository.findById(907L)).thenThrow(CustomerNotFoundException.class);
		assertThrows(CustomerNotFoundException.class, () ->customerService.getCustomer(907L));
		verify(customerRepository, times(1)).findById(907L);
	}
	
	@Test
	public void getAllCustomerTest() {
		 
		Customer customer2 = new Customer(4675 , "jhkr" , "Rom" , "afuh@g.com" , "7568967688" , LocalDate.of(2019, 10, 21) , new Address(346, "akur", "sangam", "Nagpur" , "MH" , 456782));
		Customer customer3 = new Customer(6788 , "jhkg" , "Shaw" , "jf@g.com" , "7566523688" , LocalDate.of(2021, 12, 15) , new Address(347, "lig", "indira", "Mumbai" , "MH" , 456492));
		
		List<Customer> customers=new ArrayList<>();
		customers.add(customer);
		customers.add(customer2);
		customers.add(customer3);
		when(customerRepository.findAll()).thenReturn(Stream
				.of(customer,customer2,customer3).collect(Collectors.toList()));
		assertEquals(customers, customerService.getAllCustomers());
		verify(customerRepository,times(1)).findAll();
	}
	
	
	@AfterEach
	public void tearDown() {
		address=null;
		customer=null;
	}

	
}
