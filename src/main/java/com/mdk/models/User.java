package com.mdk.models;

import java.math.BigDecimal;

enum UserRole {}

public class User extends AbstractModel<Delivery> {
	private String firstname;
	private String lastname;
	private String id_card;
	private String email;
	private String phone;
	private boolean IsEmailActive;
	private boolean isPhoneActive;
	private String password;
	private UserRole role;
	private String avatar;
	private Double eWallet;
	
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
	
	
	public String getId_card() {
		return id_card;
	}
	
	public void setId_card(String id_card) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double geteWallet() {
		return eWallet;
	}

	public void seteWallet(Double eWallet) {
		this.eWallet = eWallet;
	}

}
