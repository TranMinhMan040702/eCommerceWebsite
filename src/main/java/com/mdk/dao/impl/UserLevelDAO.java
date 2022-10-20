package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IUserLevelDAO;
import com.mdk.models.StyleValue;
import com.mdk.models.UserLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserLevelDAO extends DBConnection implements IUserLevelDAO {

    @Override
    public List<UserLevel> findALL() {
        String sql = "SELECT name, minPoint, discount FROM userLevel";
        List<UserLevel> userLevels = new ArrayList<UserLevel>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                UserLevel userLevel = new UserLevel();
                userLevel.setName(resultSet.getString("name"));
                userLevel.setMinPoint(resultSet.getInt("minPoint"));
                userLevel.setDiscount(resultSet.getBigDecimal("discount"));
                userLevels.add(userLevel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLevels;
    }

    @Override
    public void insert(UserLevel userLevel) {
        String sql = "INSERT INTO userLevel(name, minPoint, discount) VALUES (?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userLevel.getName());
            ps.setInt(2, userLevel.getMinPoint());
            ps.setBigDecimal(3, userLevel.getDiscount());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(UserLevel userLevel) {
        String sql = "UPDATE userLevel SET name = ?, minPoint = ?, discount = ? WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userLevel.getName());
            ps.setInt(2, userLevel.getMinPoint());
            ps.setBigDecimal(3, userLevel.getDiscount());
            ps.setLong(4, userLevel.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSoft(UserLevel userLevel) {
        String sql = "UPDATE userLevel SET isDeleted = true WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, userLevel.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restore(UserLevel userLevel) {
        String sql = "UPDATE userLevel SET isDeleted = false WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, userLevel.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
