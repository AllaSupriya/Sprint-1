package com.ec.onlineplantnursery.plant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Plant {
	@Id
	private Integer plantId;
	
	@Positive(message = "plantHeight should be positive")
	private Integer plantHeight;
	
	@NotEmpty(message = "plantSpread cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid plantSpread, plantSpread should have minimum 3 and maximum 15 characters")
	private String plantSpread;
	
	@NotEmpty(message = "commonName cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid commonName, commonName should have minimum 3 and maximum 15 characters")
	private String commonName;
	
	@NotEmpty(message = "bloomTime cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid bloomTime,bloomTime should have minimum 3 and maximum 15 characters")
	private String bloomTime;
	
	@NotEmpty(message = "medicinalOrCulinaryUse cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid medicinalOrCulinaryUse, medicinalOrCulinaryUse should have minimum 3 and maximum 15 characters")
	private String medicinalOrCulinaryUse;
	
	@NotEmpty(message = "difficultyLevel cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid difficultyLevel, difficultyLevel should have minimum 3 and maximum 15 characters")
	private String difficultyLevel;
	
	@NotEmpty(message = "temparature cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid temparature, temparature should have minimum 3 and maximum 15 characters")
	private String temparature;
	
	@NotEmpty(message = "typeOfPlant cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid typeOfPlant, typeOfPlant should have minimum 3 and maximum 15 characters")
	private String typeOfPlant;
	
	@NotEmpty(message = "plantDescription cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid plantDescription, plantDescription should have minimum 3 and maximum 15 characters")
	private String plantDescription;
	
	@Positive(message = "plantStock should be positive")
	private Integer plantsStock;
	
	@Positive(message = "plantCost should be positive")
	private double plantCost;
	public Plant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plant(Integer plantId, Integer plantHeight, String plantSpread, String commonName, String bloomTime,
			String medicinalOrCulinaryUse, String difficultyLevel, String temparature, String typeOfPlant,
			String plantDescription, Integer plantsStock, double plantCost) {
		super();
		this.plantId = plantId;
		this.plantHeight = plantHeight;
		this.plantSpread = plantSpread;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfPlant = typeOfPlant;
		this.plantDescription = plantDescription;
		this.plantsStock = plantsStock;
		this.plantCost = plantCost;
	}
	public Integer getPlantId() {
		return plantId;
	}
	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}
	public Integer getPlantHeight() {
		return plantHeight;
	}
	public void setPlantHeight(Integer plantHeight) {
		this.plantHeight = plantHeight;
	}
	public String getPlantSpread() {
		return plantSpread;
	}
	public void setPlantSpread(String plantSpread) {
		this.plantSpread = plantSpread;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getBloomTime() {
		return bloomTime;
	}
	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}
	public String getMedicinalOrCulinaryUse() {
		return medicinalOrCulinaryUse;
	}
	public void setMedicinalOrCulinaryUse(String medicinalOrCulinaryUse) {
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public String getTemparature() {
		return temparature;
	}
	public void setTemparature(String temparature) {
		this.temparature = temparature;
	}
	public String getTypeOfPlant() {
		return typeOfPlant;
	}
	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
	}
	public String getPlantDescription() {
		return plantDescription;
	}
	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}
	public Integer getPlantsStock() {
		return plantsStock;
	}
	public void setPlantsStock(Integer plantsStock) {
		this.plantsStock = plantsStock;
	}
	public double getPlantCost() {
		return plantCost;
	}
	public void setPlantCost(double plantCost) {
		this.plantCost = plantCost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloomTime == null) ? 0 : bloomTime.hashCode());
		result = prime * result + ((commonName == null) ? 0 : commonName.hashCode());
		result = prime * result + ((difficultyLevel == null) ? 0 : difficultyLevel.hashCode());
		result = prime * result + ((medicinalOrCulinaryUse == null) ? 0 : medicinalOrCulinaryUse.hashCode());
		long temp;
		temp = Double.doubleToLongBits(plantCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((plantDescription == null) ? 0 : plantDescription.hashCode());
		result = prime * result + ((plantHeight == null) ? 0 : plantHeight.hashCode());
		result = prime * result + ((plantId == null) ? 0 : plantId.hashCode());
		result = prime * result + ((plantSpread == null) ? 0 : plantSpread.hashCode());
		result = prime * result + ((plantsStock == null) ? 0 : plantsStock.hashCode());
		result = prime * result + ((temparature == null) ? 0 : temparature.hashCode());
		result = prime * result + ((typeOfPlant == null) ? 0 : typeOfPlant.hashCode());
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
		Plant other = (Plant) obj;
		if (bloomTime == null) {
			if (other.bloomTime != null)
				return false;
		} else if (!bloomTime.equals(other.bloomTime))
			return false;
		if (commonName == null) {
			if (other.commonName != null)
				return false;
		} else if (!commonName.equals(other.commonName))
			return false;
		if (difficultyLevel == null) {
			if (other.difficultyLevel != null)
				return false;
		} else if (!difficultyLevel.equals(other.difficultyLevel))
			return false;
		if (medicinalOrCulinaryUse == null) {
			if (other.medicinalOrCulinaryUse != null)
				return false;
		} else if (!medicinalOrCulinaryUse.equals(other.medicinalOrCulinaryUse))
			return false;
		if (Double.doubleToLongBits(plantCost) != Double.doubleToLongBits(other.plantCost))
			return false;
		if (plantDescription == null) {
			if (other.plantDescription != null)
				return false;
		} else if (!plantDescription.equals(other.plantDescription))
			return false;
		if (plantHeight == null) {
			if (other.plantHeight != null)
				return false;
		} else if (!plantHeight.equals(other.plantHeight))
			return false;
		if (plantId == null) {
			if (other.plantId != null)
				return false;
		} else if (!plantId.equals(other.plantId))
			return false;
		if (plantSpread == null) {
			if (other.plantSpread != null)
				return false;
		} else if (!plantSpread.equals(other.plantSpread))
			return false;
		if (plantsStock == null) {
			if (other.plantsStock != null)
				return false;
		} else if (!plantsStock.equals(other.plantsStock))
			return false;
		if (temparature == null) {
			if (other.temparature != null)
				return false;
		} else if (!temparature.equals(other.temparature))
			return false;
		if (typeOfPlant == null) {
			if (other.typeOfPlant != null)
				return false;
		} else if (!typeOfPlant.equals(other.typeOfPlant))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", plantHeight=" + plantHeight + ", plantSpread=" + plantSpread
				+ ", commonName=" + commonName + ", bloomTime=" + bloomTime + ", medicinalOrCulinaryUse="
				+ medicinalOrCulinaryUse + ", difficultyLevel=" + difficultyLevel + ", temparature=" + temparature
				+ ", typeOfPlant=" + typeOfPlant + ", plantDescription=" + plantDescription + ", plantsStock="
				+ plantsStock + ", plantCost=" + plantCost + "]";
	}
	
	
	
}
