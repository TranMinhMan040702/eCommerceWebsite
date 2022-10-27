package com.mdk.models;

import java.math.BigDecimal;

public class Orders extends AbstractModel<Orders> {
    private Long userId;
    private Long storeId;
    private Long deliveryId;
    private Long commissionId;
    private String address;
    private int phone;
    private String status;
    private Boolean isPaidBefore;
    private BigDecimal amountFromUser;
    private BigDecimal amountFromStore;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Long commissionId) {
        this.commissionId = commissionId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getPaidBefore() {
        return isPaidBefore;
    }

    public void setPaidBefore(Boolean paidBefore) {
        isPaidBefore = paidBefore;
    }

    public BigDecimal getAmountFromUser() {
        return amountFromUser;
    }

    public void setAmountFromUser(BigDecimal amountFromUser) {
        this.amountFromUser = amountFromUser;
    }

    public BigDecimal getAmountFromStore() {
        return amountFromStore;
    }

    public void setAmountFromStore(BigDecimal amountFromStore) {
        this.amountFromStore = amountFromStore;
    }

    public BigDecimal getAmountToStore() {
        return amountToStore;
    }

    public void setAmountToStore(BigDecimal amountToStore) {
        this.amountToStore = amountToStore;
    }

    public BigDecimal getAmountToGD() {
        return amountToGD;
    }

    public void setAmountToGD(BigDecimal amountToGD) {
        this.amountToGD = amountToGD;
    }

    private BigDecimal amountToStore;
    private BigDecimal amountToGD;
}
