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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingOrderId == null) ? 0 : bookingOrderId.hashCode());
		result = prime * result + cid;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + pid;
		result = prime * result + ((planters == null) ? 0 : planters.hashCode());
		result = prime * result + quantity;
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transactionMode == null) ? 0 : transactionMode.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (bookingOrderId == null) {
			if (other.bookingOrderId != null)
				return false;
		} else if (!bookingOrderId.equals(other.bookingOrderId))
			return false;
		if (cid != other.cid)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (pid != other.pid)
			return false;
		if (planters == null) {
			if (other.planters != null)
				return false;
		} else if (!planters.equals(other.planters))
			return false;
		if (quantity != other.quantity)
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		if (transactionMode == null) {
			if (other.transactionMode != null)
				return false;
		} else if (!transactionMode.equals(other.transactionMode))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Order [bookingOrderId=" + bookingOrderId + ", orderDate=" + orderDate + ", transactionMode="
				+ transactionMode + ", quantity=" + quantity + ", totalCost=" + totalCost + ", planters=" + planters
				+ ", customer=" + customer + ", cid=" + cid + ", pid=" + pid + "]";
	}






	
	
	
}