package com.ec.onlineplantnursery.order.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.customer.service.ICustomerServiceImpl;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.service.IPlanterServiceImpl;

@Entity
@Table(name = "OrderDetails")
public class Order {
	
	@Id
	@Positive(message = "Id should be positive")
	Integer bookingOrderId;
	LocalDate orderDate;
	@NotEmpty(message = "transactionMode cannot be left blank or null")
	String transactionMode;
	@Positive(message = "quantity should be positive")
	int quantity;
	@Positive(message = "totalCost should be positive")
	double totalCost;
	
	@OneToOne
	@JoinColumn(name = "planterId", referencedColumnName = "planterId")
	Planter planters;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "planterId", referencedColumnName = "planterId")
//	List<Planter> planters;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	Customer customer;
	
	int cid;
	int pid;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Order(Integer bookingOrderId, LocalDate orderDate, String transactionMode, int quantity,
			double totalCost,int cid,int pid) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.cid = cid;
		this.pid = pid;
	}
	
	

	public Order(Integer bookingOrderId, LocalDate orderDate, String transactionMode, int quantity, double totalCost,
			Planter planters, Customer customer) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.planters = planters;
		this.customer = customer;
	}
	
	

	public Order(
			@NotEmpty(message = "Id cannot be left blank or null") @Positive(message = "Id should be positive") Integer bookingOrderId,
			@NotEmpty(message = "Order date cannot be left blank or null") LocalDate orderDate,
			@NotEmpty(message = "transactionMode cannot be left blank or null") String transactionMode,
			@NotEmpty(message = "quantity cannot be left blank or null") @Positive(message = "quantity should be positive") int quantity,
			@NotEmpty(message = "totalCost cannot be left blank or null") @Positive(message = "totalCost should be positive") double totalCost,
			Planter planters, Customer customer, int cid, int pid) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.planters = planters;
		this.customer = customer;
		this.cid = cid;
		this.pid = pid;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
				+ ", customer=" + customer + ", cid=" + cid + ", pid=" + pid + "]";
	}






	
	
	
}
