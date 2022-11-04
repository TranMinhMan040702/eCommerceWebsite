package com.mdk.models;

import java.math.BigDecimal;

public class Store extends AbstractModel<Delivery> {
	private String name;
	private String bio;
	private int ownerID;
	private boolean isOpen;
	private String avatar;
	private String featured_images;
	private int rating;
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


	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int raitng) {
		this.rating = raitng;
	}

	public BigDecimal getE_wallet() {
		return e_wallet;
	}

	public void setE_wallet(BigDecimal e_wallet) {
		this.e_wallet = e_wallet;
	}
}
