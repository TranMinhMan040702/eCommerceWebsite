package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IStoreLevelDAO;
import com.mdk.models.StoreLevel;
import com.mdk.models.UserLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StoreLevelDAO extends DBConnection implements IStoreLevelDAO {

    @Override
    public List<StoreLevel> findALL() {
        String sql = "SELECT name, minPoint, discount FROM storeLevel";
        List<StoreLevel> storeLevels = new ArrayList<StoreLevel>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                StoreLevel storeLevel = new StoreLevel();
                storeLevel.setName(resultSet.getString("name"));
                storeLevel.setMinPoint(resultSet.getInt("minPoint"));
                storeLevel.setDiscount(resultSet.getBigDecimal("discount"));
                storeLevels.add(storeLevel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storeLevels;
    }

    @Override
    public void insert(StoreLevel storeLevel) {
        String sql = "INSERT INTO storeLevel(name, minPoint, discount) VALUES (?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, storeLevel.getName());
            ps.setInt(2, storeLevel.getMinPoint());
            ps.setBigDecimal(3, storeLevel.getDiscount());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(StoreLevel storeLevel) {
        String sql = "UPDATE storeLevel SET name = ?, minPoint = ?, discount = ? WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, storeLevel.getName());
            ps.setInt(2, storeLevel.getMinPoint());
            ps.setBigDecimal(3, storeLevel.getDiscount());
            ps.setLong(4, storeLevel.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSoft(StoreLevel storeLevel) {
        String sql = "UPDATE storeLevel SET isDeleted = true WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, storeLevel.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restore(StoreLevel storeLevel) {
        String sql = "UPDATE storeLevel SET isDeleted = false WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, storeLevel.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
