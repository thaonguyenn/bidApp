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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "Product")
public class Product {
	@Id
	private String idProduct;
	private String nameProduct;
//	@ManyToOne
//	@JoinColumn(name = "idCategory")
//	private Category category;
	private String description;
	private double price;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduct")
	private Set<BidSessions> listSession;
	
	@OneToMany(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "idProduct")
	private Set<ImageProduct> listImages;
	
	@Column(name = "createDay")
	private Date createDay;
	
	@Column(name = "presentStatus")
	private int presentStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCus")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idOwner")
	private Customer owner;

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreateDay() {
		return createDay;
	}

	public void setCreateDay(Date createDay) {
		this.createDay = createDay;
	}

	public int getPresentStatus() {
		return presentStatus;
	}

	public void setPresentStatus(int presentStatus) {
		this.presentStatus = presentStatus;
	}

//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public Set<BidSessions> getListSession() {
		return listSession;
	}

	public void setListSession(Set<BidSessions> listSession) {
		this.listSession = listSession;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public Set<ImageProduct> getListImages() {
		return listImages;
	}

	public void setListImages(Set<ImageProduct> listImages) {
		this.listImages = listImages;
	}
	
	
}
