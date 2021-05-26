package com.ec.onlineplantnursery.planter.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.seed.entity.Seed;

@Entity
public class Planter {
	
	@Id
	Integer planterId;
	
	@Positive(message = "planterheight should be positive")
	float planterheight;
	
	@Positive(message = "planterCapacity should be positive")
	int planterCapacity;
	
	@Positive(message = "drinageHoles should be positive")
	int drinageHoles;
	
	@Positive(message = "planterColor should be positive")
	int planterColor;
	
	@NotEmpty(message = "planterShape cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid planterShape, planterShape should have minimum 3 and maximum 15 characters")
	String planterShape;
	
	@Positive(message = "planterStock should be positive")
	int planterStock;
	
	@Positive(message = "planterCost should be positive")
	int planterCost;
	
//	@ManyToOne
//	@JoinColumn(name="PlanterId")
//	Order order;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "plantId", referencedColumnName = "plantId")
	Plant plants;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seedId", referencedColumnName = "seedId")
	Seed seeds;
	
	public Planter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Planter(Integer planterId, float planterheight, int planterCapacity, int drinageHoles, int planterColor,
			String planterShape, int planterStock, int planterCost, Plant plants, Seed seeds) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.plants = plants;
		this.seeds = seeds;
	}

	

	public Planter(Integer planterId, float planterheight, int planterCapacity, int drinageHoles, int planterColor,
			String planterShape, int planterStock, int planterCost, Plant plants) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.plants = plants;
	}

	

	public Planter(Integer planterId, float planterheight, int planterCapacity, int drinageHoles, int planterColor,
			String planterShape, int planterStock, int planterCost, Seed seeds) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.seeds = seeds;
	}


	public Integer getPlanterId() {
		return planterId;
	}


	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}


	public float getPlanterheight() {
		return planterheight;
	}


	public void setPlanterheight(float planterheight) {
		this.planterheight = planterheight;
	}


	public int getPlanterCapacity() {
		return planterCapacity;
	}


	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}


	public int getDrinageHoles() {
		return drinageHoles;
	}


	public void setDrinageHoles(int drinageHoles) {
		this.drinageHoles = drinageHoles;
	}


	public int getPlanterColor() {
		return planterColor;
	}


	public void setPlanterColor(int planterColor) {
		this.planterColor = planterColor;
	}


	public String getPlanterShape() {
		return planterShape;
	}


	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}


	public int getPlanterStock() {
		return planterStock;
	}


	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}


	public int getPlanterCost() {
		return planterCost;
	}


	public void setPlanterCost(int planterCost) {
		this.planterCost = planterCost;
	}


	public Plant getPlant() {
		return plants;
	}


	public void setPlant(Plant plants) {
		this.plants = plants;
	}


	public Seed getSeed() {
		return seeds;
	}


	public void setSeed(Seed seeds) {
		this.seeds = seeds;
	}


	@Override
	public String toString() {
		return "Planter [planterId=" + planterId + ", planterheight=" + planterheight + ", planterCapacity="
				+ planterCapacity + ", drinageHoles=" + drinageHoles + ", planterColor=" + planterColor
				+ ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", planterCost=" + planterCost
				+ ", plant=" + plants + ", seed=" + seeds + "]";
	}
	
	
	
}
