package com.cg.cars.models;

public class Payment {
	private long id;
	private String type;
	private String status;
	private Card card;
	public Payment() {
	}
	public Payment(long id, String type, String status, Card card) {
		this.id = id;
		this.type = type;
		this.status = status;
		this.card = card;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}
	
	
}
