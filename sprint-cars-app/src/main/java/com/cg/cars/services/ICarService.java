package com.cg.cars.services;

import java.util.List;

import com.cg.cars.models.Car;

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

public interface ICarService {
	
	public Car addCar(Car car);
	
	public Car getCarById(long id);

	public List<Car> getAllCars();

	public List<Car> getCarsByLocation(String registrationState);

	public List<Car> getCarsByYear(String year);

	public List<Car> getCarsByModel(String model);

	public List<Car> getCarsByBrand(String brand);

	public List<Car> getCarsByModelColor(String model, String color);

	public List<Car> getCarsByPrice(double price);

	public Car update(long id, Car car);

	public Car delete(long id);

	public List<Car> getCarsByPriceRange(double start, double end);

}
