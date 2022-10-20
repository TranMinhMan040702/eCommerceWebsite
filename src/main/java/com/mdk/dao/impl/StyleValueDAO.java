package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IStyleValueDAO;
import com.mdk.models.Style;
import com.mdk.models.StyleValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StyleValueDAO extends DBConnection implements IStyleValueDAO {

    @Override
    public List<StyleValue> findALL() {
        String sql = "SELECT name FROM styleValue";
        List<StyleValue> styleValues = new ArrayList<StyleValue>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                StyleValue styleValue = new StyleValue();
                styleValue.setName(resultSet.getString("name"));
                styleValues.add(styleValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return styleValues;
    }

    @Override
    public void insert(StyleValue styleValue) {
        String sql = "INSERT INTO styleValue(name) VALUES (?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, styleValue.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(StyleValue styleValue) {
        String sql = "UPDATE styleValue SET name = ? WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, styleValue.getName());
            ps.setLong(2, styleValue.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSoft(StyleValue styleValue) {
        String sql = "UPDATE styleValue SET isDeleted = true WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, styleValue.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restore(StyleValue styleValue) {
        String sql = "UPDATE styleValue SET isDeleted = false WHERE _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, styleValue.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
