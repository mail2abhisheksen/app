package com.cg.cars.models;

import java.time.LocalDate;

public class Card {
	private String name;
	private String number;
    private LocalDate expiry;
    private int cvv;
    
	public Card() {
	}

	public Card(String name, String number, LocalDate expiry, int cvv) {
		this.name = name;
		this.number = number;
		this.expiry = expiry;
		this.cvv = cvv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + ", number=" + number + ", expiry=" + expiry + ", cvv=" + cvv + "]";
	}
    
    
    
    
}
