package com.mdk.models;

import java.math.BigDecimal;

public class UserLevel extends AbstractModel<Delivery> {
	private String name;
	private int minPoint;
	private BigDecimal discount;
	private boolean isDelete;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMinPoint() {
		return minPoint;
	}
	
	public void setMinPoint(int minPoint) {
		this.minPoint = minPoint;
	}
	
	public BigDecimal getDiscount() {
		return discount;
	}
	
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
	public boolean isDelete() {
		return isDelete;
	}
	
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}
