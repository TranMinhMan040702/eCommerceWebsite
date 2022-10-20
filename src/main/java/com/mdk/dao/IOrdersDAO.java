package com.mdk.dao;

import com.mdk.models.Orders;

import java.util.List;

public interface IOrdersDAO {
    List<Orders> findAll();
    List<Orders> findDelivering();
    void updateStatus(Orders orders);


}
