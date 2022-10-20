package com.mdk.services.impl;

import com.mdk.dao.IOrdersDAO;
import com.mdk.dao.impl.OrdersDAO;
import com.mdk.models.Orders;
import com.mdk.services.IOrdersService;

import java.util.List;

public class OrdersServiceImpl implements IOrdersService {
    IOrdersDAO ordersDAO = new OrdersDAO();
    @Override
    public List<Orders> findAll() {
        return ordersDAO.findAll();
    }

    @Override
    public List<Orders> findDelivering() {
        return ordersDAO.findDelivering();
    }

    @Override
    public void updateStatus(Orders orders) {
        ordersDAO.updateStatus(orders);
    }
}
