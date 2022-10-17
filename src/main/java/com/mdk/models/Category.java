package com.mdk.models;

import java.math.BigDecimal;

public class Category extends AbstractModel<Delivery> {
	private String name;
	private String slug;
	private long categoryId;
	private String image;
	private boolean isDelete;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public boolean isDelete() {
		return isDelete;
	}
	
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
}
