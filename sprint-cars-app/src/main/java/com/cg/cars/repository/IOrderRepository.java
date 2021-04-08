package com.cg.cars.repository;

import java.util.List;

import com.cg.cars.model.Order;

public interface IOrderRepository {
	public Order addOrder(Order order);
	public Order removeOrder(long id);
	public Order  updateOrder(long id, Order order);
	public Order  getOrderDetails(long id);
	public List<Order> getAllOrders(); 

}
