package com.cg.cars.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.cars.models.Payment;

public interface IPaymentRepository extends CrudRepository<Payment, Long>{
//	public Payment addPayment(Payment payment);
//	public Payment removePayment(long id);
//	public Payment updatePayment(long id, Payment payment);
//	public Payment getPaymentDetails(long id);
//	public List<Payment> getAllPaymentDetails();
}
