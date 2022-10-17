package com.mdk.models;

import java.math.BigDecimal;

enum UserRole {}

public class User extends AbstractModel<Delivery> {
	private String firstname;
	private String lastname;
	private String slug;
	private long id_card;
	private String email;
	private String phone;
	private boolean IsEmailActive;
	private boolean isPhoneActive;
	private String salt;
	private String hashed_password;
	private UserRole role;
	private String avatar;
	private String cover;
	private int point;
	private BigDecimal e_wallet;
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	public long getId_card() {
		return id_card;
	}
	
	public void setId_card(long id_card) {
		this.id_card = id_card;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean isIsEmailActive() {
		return IsEmailActive;
	}
	
	public void setIsEmailActive(boolean isEmailActive) {
		IsEmailActive = isEmailActive;
	}
	
	public boolean isPhoneActive() {
		return isPhoneActive;
	}
	
	public void setPhoneActive(boolean isPhoneActive) {
		this.isPhoneActive = isPhoneActive;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getHashed_password() {
		return hashed_password;
	}
	
	public void setHashed_password(String hashed_password) {
		this.hashed_password = hashed_password;
	}
	
	public UserRole getRole() {
		return role;
	}
	
	public void setRole(UserRole role) {
		this.role = role;
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
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public BigDecimal getE_wallet() {
		return e_wallet;
	}
	
	public void setE_wallet(BigDecimal e_wallet) {
		this.e_wallet = e_wallet;
	}
}
