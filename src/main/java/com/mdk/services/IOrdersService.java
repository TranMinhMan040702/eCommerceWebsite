package com.mdk.services;

import com.mdk.models.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll();
    List<Orders> findDelivering();
    void updateStatus(Orders orders);
}
