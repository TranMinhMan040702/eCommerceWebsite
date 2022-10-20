package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IOrdersDAO;
import com.mdk.models.Orders;
import com.mdk.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends DBConnection implements IOrdersDAO {
    @Override
    public List<Orders> findAll() {
        String sql = "SELECT * FROM orders";
        List<Orders> orders = new ArrayList<Orders>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                Orders oder = new Orders();
                oder.setUserId(resultSet.getLong("userId"));
                oder.setStoreId(resultSet.getLong("storeId"));
                oder.setDeliveryId(resultSet.getLong("deliveryId"));
                oder.setAddress(resultSet.getString("address"));
                oder.setPhone(resultSet.getInt("phone"));
                oder.setStatus(resultSet.getString("status"));
                orders.add(oder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Orders> findDelivering() {
        String sql = "SELECT * FROM orders WHERE status = 'shipped'";
        List<Orders> orders = new ArrayList<Orders>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                Orders oder = new Orders();
                oder.setUserId(resultSet.getLong("userId"));
                oder.setStoreId(resultSet.getLong("storeId"));
                oder.setDeliveryId(resultSet.getLong("deliveryId"));
                oder.setAddress(resultSet.getString("address"));
                oder.setPhone(resultSet.getInt("phone"));
                oder.setStatus(resultSet.getString("status"));
                orders.add(oder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void updateStatus(Orders orders) {
        String sql = "UPDATE user SET status = ?";
        List<User> users = new ArrayList<User>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            pStatement.setString(1, orders.getStatus());
            pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
