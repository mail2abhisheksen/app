package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.PaymentNotFoundException;
import com.cg.cars.models.Payment;
import com.cg.cars.repositories.IPaymentRepository;

@Service
public class PaymentService implements IPaymentService{
	
	@Autowired
	IPaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment removePayment(long id) {
		Payment payment=getPaymentDetails(id);
		paymentRepository.deleteById(id);
		return payment;
	}

	@Override
	public Payment updatePayment(long id,Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment getPaymentDetails(long id) {
		return paymentRepository.findById(id).orElseThrow(()->new PaymentNotFoundException("No payment with id "+id+" found"));
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		List<Payment> payments=new ArrayList<>();
		paymentRepository.findAll().forEach(p -> payments.add(p));
		return payments;
	}

}
