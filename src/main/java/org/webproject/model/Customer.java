package org.webproject.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "Customer")
public class Customer {
	@Id
	private String idCus;
	private String fullName;
	private String phoneNumber;
	private String address;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCus")
	private Account account;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCus")
	private Set<SessionItems> sessionItems;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCus")
	private Set<Orders> orders;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCus")
	private Set<Product> productsOwner;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCus")
	private Set<Product> productsBuyer;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Set<SessionItems> getSessionItems() {
		return sessionItems;
	}
	public void setSessionItems(Set<SessionItems> sessionItems) {
		this.sessionItems = sessionItems;
	}
	public String getIdCus() {
		return idCus;
	}
	public void setIdCus(String idCus) {
		this.idCus = idCus;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	public Set<Product> getProductsOwner() {
		return productsOwner;
	}
	public void setProductsOwner(Set<Product> productsOwner) {
		this.productsOwner = productsOwner;
	}
	public Set<Product> getProductsBuyer() {
		return productsBuyer;
	}
	public void setProductsBuyer(Set<Product> productsBuyer) {
		this.productsBuyer = productsBuyer;
	}
	
	

}

//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;
//
//@Entity
//@Table(name = "Customer")
//public class Customer {
//	@Id
//	@NotNull
//	@Column(name = "idCus")
//	private String idCus;
//	@Column(name="fullName")
//	private String fullName;
//	@Column(name="phoneNumber")
//	private String phoneNumber;
//	@Column(name="address")
//	private String address;
//	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "idCus")
//	private Account account;
//	
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "CustomerID")
//	private List<SessionItems> sessionItems;
//	
//	@OneToMany
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@JoinColumn(name = "idOrders")
//	List<Orders> orders;
//	
//	@OneToMany
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@JoinColumn(name = "idCus")
//	List<Product> productOwn;
//	
//	
//	public String getIdCus() {
//		return idCus;
//	}
//	public void setIdCus(String idCus) {
//		this.idCus = idCus;
//	}
//	public String getFullName() {
//		return fullName;
//	}
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//		
//	}
//	public Account getAccount() {
//		return account;
//	}
//	public void setAccount(Account account) {
//		this.account = account;
//	}
//	
//	public List<SessionItems> getSessionItems() {
//		return sessionItems;
//	}
//	public void setSessionItems(List<SessionItems> sessionItems) {
//		this.sessionItems = sessionItems;
//	}
//	public List<Orders> getOrders() {
//		return orders;
//	}
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}
//	public List<Product> getProductOwn() {
//		return productOwn;
//	}
//	public void setProductOwn(List<Product> productOwn) {
//		this.productOwn = productOwn;
//	}
//	
//
//	
//	
//}
