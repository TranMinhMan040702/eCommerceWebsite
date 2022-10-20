package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IUserDAO;
import com.mdk.models.User;
import com.mdk.models.User_1000;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBConnection implements IUserDAO {

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        List<User> users = new ArrayList<User>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setId_card(resultSet.getLong("id_card"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPoint(resultSet.getInt("point"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }

    @Override
    public List<User_1000> find1000UsersLatestCreationTime() {
        String sql = "SELECT COUNT(_id) as quantity, point FROM (" +
                "SELECT TOP 1000 * FROM user) GROUP BY point ORDER BY createdAt DESC";
        List<User_1000> users_1000 = new ArrayList<User_1000>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                User_1000 user = new User_1000();
                user.setQuatity_group(resultSet.getInt("quantity"));
                user.setPoint(resultSet.getInt("point"));
                users_1000.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users_1000;
    }

    @Override
    public int totalUsers() {
        String sql = "SELECT COUNT(_id) as total FROM user";
        int result = 0;
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            result = pStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> topUsers() {
        String sql = "SELECT TOP 10 * FROM user ORDER BY point DESC";
        List<User> users = new ArrayList<User>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setId_card(resultSet.getLong("id_card"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPoint(resultSet.getInt("point"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
