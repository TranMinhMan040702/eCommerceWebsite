package com.mdk.models;

import java.math.BigDecimal;

public class Commission extends AbstractModel<Delivery> {
	private String name;
	private BigDecimal cost;
	private String description;
	private boolean isDelete;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isDelete() {
		return isDelete;
	}
	
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}
