package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.ICommissionDAO;
import com.mdk.models.Commission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommissionDAO extends DBConnection implements ICommissionDAO {
    @Override
    public List<Commission> findALL() {
        String sql = "SELECT name, description, cost FROM commission";
        List<Commission> commissions = new ArrayList<Commission>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                Commission commission = new Commission();
                commission.setName(resultSet.getString("name"));
                commission.setDescription(resultSet.getString("description"));
                commission.setCost(resultSet.getBigDecimal("cost"));
                commissions.add(commission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commissions;
    }

    @Override
    public void insert(Commission commission) {
        String sql = "INSERT INTO commission(name, description, cost) VALUES (?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, commission.getName());
            ps.setString(2, commission.getDescription());
            ps.setBigDecimal(3, commission.getCost());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Commission commission) {
        String sql = "UPDATE commission SET name = ?, description = ?, cost = ? WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, commission.getName());
            ps.setString(2, commission.getDescription());
            ps.setBigDecimal(3, commission.getCost());
            ps.setLong(4, commission.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSoft(Commission commission) {
        String sql = "UPDATE commission SET isDeleted = true WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, commission.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restore(Commission commission) {
        String sql = "UPDATE commission SET isDeleted = false WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, commission.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
