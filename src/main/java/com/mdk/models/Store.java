package com.mdk.models;

import java.math.BigDecimal;

public class Store extends AbstractModel<Delivery> {
	private String name;
	private String bio;
	private String slug;
	private long ownerID;
	private boolean isActive;
	private boolean isOpen;
	private String avatar;
	private String cover;
	private int commission;
	private int point;
	private int raitng;
	private BigDecimal e_wallet;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBio() {
		return bio;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	public long getOwnerID() {
		return ownerID;
	}
	
	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getCover() {
		return cover;
	}
	
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public int getCommission() {
		return commission;
	}
	
	public void setCommission(int commission) {
		this.commission = commission;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public int getRaitng() {
		return raitng;
	}
	
	public void setRaitng(int raitng) {
		this.raitng = raitng;
	}
	
	public BigDecimal getE_wallet() {
		return e_wallet;
	}
	
	public void setE_wallet(BigDecimal e_wallet) {
		this.e_wallet = e_wallet;
	}
}