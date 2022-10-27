package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IProductDAO;
import com.mdk.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ProductDAO extends DBConnection implements IProductDAO {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public void update(Product product) {
        StringBuilder sql = new StringBuilder("update product set name = ?, description = ?, ");
        sql.append("price = ?, promotionalPrice = ?, quantity = ?, sold = ?, categoryId = ? where _id = ?");
        try {
            conn = getConnection();
            ps = Objects.requireNonNull(conn).prepareStatement(String.valueOf(sql));
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setBigDecimal(3, product.getPrice());
            ps.setBigDecimal(4, product.getPromotionalPrice());
            ps.setInt(5, product.getQuantity());
            ps.setInt(6, product.getSold());
            ps.setLong(7, product.getCategoryId());
            ps.setLong(8, product.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int totalProductByStore(long storeId) {
        String sql = "select count(*), storeId from product where storeId = ? group by(storeId)";
        int total = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, storeId);
            rs = ps.executeQuery();
            while (rs.next()){
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
