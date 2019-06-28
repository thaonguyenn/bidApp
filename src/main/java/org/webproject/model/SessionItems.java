package org.webproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "SessionItems")
public class SessionItems {
	@Id
	private String ItemID;
	@ManyToOne
	@JoinColumn(name = "SessionID")
	BidSessions bidsessions;
	@ManyToOne
	@JoinColumn(name = "CustomerID")
	Customer customer;
	private Date ItemTime;
	private double Price;
	public String getItemID() {
		return ItemID;
	}
	public void setItemID(String itemID) {
		ItemID = itemID;
	}
	public BidSessions getBidsessions() {
		return bidsessions;
	}
	public void setBidsessions(BidSessions bidsessions) {
		this.bidsessions = bidsessions;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Date getItemTime() {
		return ItemTime;
	}
	public void setItemTime(Date itemTime) {
		ItemTime = itemTime;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
}
