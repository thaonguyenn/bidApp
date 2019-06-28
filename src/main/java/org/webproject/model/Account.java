package org.webproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AccountCus")
public class Account {
	@Id
	@NotNull
	@Column(name = "idCus")
	private String idCus;

	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@OneToOne
	@JoinColumn(name = "idCus", nullable = false)
	 private Customer customer;
	 
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getIdCus() {
		return idCus;
	}

	public void setIdCus(String idCus) {
		this.idCus = idCus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

}
