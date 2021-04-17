package com.cg.cars.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.cars.models.Order;

public interface IOrderService {
	public Order addOrder(long id, LocalDate billingDate, long custId, List<Long> carId);
	public Order removeOrder(long id);
	public Order  updateOrder(long id, Order order);
	public Order  getOrderDetails(long id);
	public List<Order> getOrdersByBillDate(LocalDate billingDate);
	public List<Order> getAllOrders(); 
	public String getBill(long id);

}
