package org.webproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Orders")
public class Orders {
		@Id
		@Column(name = "idOrder")
		private String idOrder;
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "idCus")
		private Customer customer;
		@Column(name = "payment")
		private String payment;
		@Column(name = "feeShip")
		private float feeShip;
		@Column(name = "total")
		private double total;
		public String getIdOrder() {
			return idOrder;
		}
		public void setIdOrder(String idOrder) {
			this.idOrder = idOrder;
		}
		public String getPayment() {
			return payment;
		}
		public void setPayment(String payment) {
			this.payment = payment;
		}
		public float getFeeShip() {
			return feeShip;
		}
		public void setFeeShip(float feeShip) {
			this.feeShip = feeShip;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		
		
}
