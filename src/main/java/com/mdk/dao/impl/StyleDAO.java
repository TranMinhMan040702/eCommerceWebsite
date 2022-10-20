package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IStyleDAO;
import com.mdk.models.Category;
import com.mdk.models.Style;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StyleDAO extends DBConnection implements IStyleDAO {

    @Override
    public List<Style> findALL() {
        String sql = "SELECT name FROM style";
        List<Style> styles = new ArrayList<Style>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                Style style = new Style();
                style.setName(resultSet.getString("name"));
                styles.add(style);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return styles;
    }

    @Override
    public void insert(Style style) {
        String sql = "INSERT INTO style(name) VALUES (?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, style.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Style style) {
        String sql = "UPDATE style SET name = ? WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, style.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSoft(Style style) {
        String sql = "UPDATE style SET isDeleted = true WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, style.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restore(Style style) {
        String sql = "UPDATE style SET isDeleted = false WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, style.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
