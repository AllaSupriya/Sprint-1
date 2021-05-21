package com.ec.onlineplantnursery.planter.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.*;

import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.seed.entity.Seed;

@Entity
public class Planter {
	
	@Id
	Integer planterId;
	
	float planterheight;
	int planterCapacity;
	int drinageHoles;
	int planterColor;
	String planterShape;
	int planterStock;
	int planterCost;
	
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
			String planterShape, int planterStock, int planterCost,Plant plants, Seed seeds) {
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



	public Plant getPlants() {
		return plants;
	}



	public void setPlants(Plant plants) {
		this.plants = plants;
	}



	public Seed getSeeds() {
		return seeds;
	}



	public void setSeeds(Seed seeds) {
		this.seeds = seeds;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + drinageHoles;
		result = prime * result + planterCapacity;
		result = prime * result + planterColor;
		result = prime * result + planterCost;
		result = prime * result + ((planterId == null) ? 0 : planterId.hashCode());
		result = prime * result + ((planterShape == null) ? 0 : planterShape.hashCode());
		result = prime * result + planterStock;
		result = prime * result + Float.floatToIntBits(planterheight);
		result = prime * result + ((plants == null) ? 0 : plants.hashCode());
		result = prime * result + ((seeds == null) ? 0 : seeds.hashCode());
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
		Planter other = (Planter) obj;
		if (drinageHoles != other.drinageHoles)
			return false;
		if (planterCapacity != other.planterCapacity)
			return false;
		if (planterColor != other.planterColor)
			return false;
		if (planterCost != other.planterCost)
			return false;
		if (planterId == null) {
			if (other.planterId != null)
				return false;
		} else if (!planterId.equals(other.planterId))
			return false;
		if (planterShape == null) {
			if (other.planterShape != null)
				return false;
		} else if (!planterShape.equals(other.planterShape))
			return false;
		if (planterStock != other.planterStock)
			return false;
		if (Float.floatToIntBits(planterheight) != Float.floatToIntBits(other.planterheight))
			return false;
		if (plants == null) {
			if (other.plants != null)
				return false;
		} else if (!plants.equals(other.plants))
			return false;
		if (seeds == null) {
			if (other.seeds != null)
				return false;
		} else if (!seeds.equals(other.seeds))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Planter [planterId=" + planterId + ", planterheight=" + planterheight + ", planterCapacity="
				+ planterCapacity + ", drinageHoles=" + drinageHoles + ", planterColor=" + planterColor
				+ ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", planterCost=" + planterCost
				+ ", plants=" + plants + ", seeds=" + seeds + "]";
	}
	
	
	
}
