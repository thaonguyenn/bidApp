package org.webproject.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity(name = "BidSessions")
public class BidSessions {
	@Id
	@Column(name = "SessionID")
	private String sessionID;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "SessionID")
	Set<SessionItems> sessionItems;
	@ManyToOne
	@JoinColumn(name = "ProductID")
	private Product product;
	private Date BidTime;
	private int PresentStatus;

	@Column(name = "countdown")
	private int countdown;
	
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public Set<SessionItems> getSessionItems() {
		return sessionItems;
	}
	public void setSessionItems(Set<SessionItems> sessionItems) {
		this.sessionItems = sessionItems;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getBidTime() {
		return BidTime;
	}
	public void setBidTime(Date bidTime) {
		BidTime = bidTime;
	}
	public int getPresentStatus() {
		return PresentStatus;
	}
	public void setPresentStatus(int presentStatus) {
		PresentStatus = presentStatus;
	}
	public int getCountdown() {
		return countdown;
	}
	public void setCountdown(int countdown) {
		this.countdown = countdown;
	}
	
}
