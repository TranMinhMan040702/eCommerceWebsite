package com.mdk.service.impl;

import com.mdk.dao.IOrderDAO;
import com.mdk.dao.impl.OrderDAO;
import com.mdk.service.IOrderService;

public class OrderService implements IOrderService{
    IOrderDAO orderDAO = new OrderDAO();
    @Override
    public int totalOder() {
        return orderDAO.totalOder();
    }
}
