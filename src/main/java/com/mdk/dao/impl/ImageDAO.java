package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IImageDAO;
import com.mdk.models.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageDAO extends DBConnection implements IImageDAO {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public void insert(Image image) {
        String sql = "insert into store_featured_images values(?, ?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, image.getId());
            ps.setString(2, image.getUrl());

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
