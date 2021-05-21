package com.ec.onlineplantnursery.order.entity;

import java.time.LocalDate;

import javax.persistence.*;


import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.planter.entity.Planter;

@Entity
@Table(name = "OrderDetails")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer bookingOrderId;
	
	LocalDate orderDate;
	String transactionMode;
	int quantity;
	double totalCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "planterId", referencedColumnName = "planterId")
	Planter planters;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	Customer customer;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Order(Integer bookingOrderId, LocalDate orderDate, String transactionMode, int quantity, double totalCost,
			Planter planters) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.planters = planters;
	}



	public Integer getBookingOrderId() {
		return bookingOrderId;
	}
	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Planter getPlanters() {
		return planters;
	}
	public void setPlanters(Planter planters) {
		this.planters = planters;
	}
	@Override
	public String toString() {
		return "Order [bookingOrderId=" + bookingOrderId + ", orderDate=" + orderDate + ", transactionMode="
				+ transactionMode + ", quantity=" + quantity + ", totalCost=" + totalCost + ", planters=" + planters
				+ "]";
	}
	
	
}
