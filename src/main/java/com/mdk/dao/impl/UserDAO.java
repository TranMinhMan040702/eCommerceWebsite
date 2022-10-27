package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IUserDAO;
import com.mdk.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DBConnection implements IUserDAO {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public User findUserById(long id) {
        String sql = "select * from user where _id = ?";
        User user = new User();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAvatar(rs.getString("avatar"));
                user.setCover(rs.getString("cover"));
                user.setCreatedAt(rs.getTimestamp("createdAt"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
