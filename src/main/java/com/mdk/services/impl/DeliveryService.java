package com.mdk.services.impl;

import com.mdk.dao.IDeliveryDAO;
import com.mdk.dao.impl.DeliveryDAO;
import com.mdk.models.Delivery;
import com.mdk.services.IDeliveryService;

import java.util.List;

public class DeliveryService implements IDeliveryService {
    IDeliveryDAO deliveryDAO = new DeliveryDAO();

    @Override
    public List<Delivery> findALL() {
        return deliveryDAO.findALL();
    }

    @Override
    public void insert(Delivery delivery) {
        deliveryDAO.insert(delivery);
    }

    @Override
    public void edit(Delivery delivery) {
        deliveryDAO.edit(delivery);
    }

    @Override
    public void deleteSoft(Delivery delivery) {
        deliveryDAO.deleteSoft(delivery);
    }

    @Override
    public void restore(Delivery delivery) {
        deliveryDAO.restore(delivery);
    }
}
