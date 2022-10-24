package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IDeliveryDAO;
import com.mdk.models.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO extends DBConnection implements IDeliveryDAO {
    @Override
    public List<Delivery> findALL() {
        String sql = "SELECT name, description, price FROM delivery";
        List<Delivery> deliveries = new ArrayList<Delivery>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setName(resultSet.getString("name"));
                delivery.setDescription(resultSet.getString("description"));
                delivery.setPrice(resultSet.getBigDecimal("price"));
                deliveries.add(delivery);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    @Override
    public void insert(Delivery delivery) {
        String sql = "INSERT INTO delivery(name, description, price) VALUES (?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, delivery.getName());
            ps.setString(2, delivery.getDescription());
            ps.setBigDecimal(3, delivery.getPrice());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Delivery delivery) {
        String sql = "UPDATE delivery SET name = ?, description = ?, price = ? WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, delivery.getName());
            ps.setString(2, delivery.getDescription());
            ps.setBigDecimal(3, delivery.getPrice());
            ps.setLong(4, delivery.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSoft(Delivery delivery) {
        String sql = "UPDATE delivery SET isDeleted = true WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, delivery.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restore(Delivery delivery) {
        String sql = "UPDATE delivery SET isDeleted = false WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, delivery.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
