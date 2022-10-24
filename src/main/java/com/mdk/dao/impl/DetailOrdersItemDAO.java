package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IDetailOrdersItemDAO;
import com.mdk.models.DetailOrdersItem;
import com.mdk.models.OrdersItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetailOrdersItemDAO extends DBConnection implements IDetailOrdersItemDAO {
    @Override
    public DetailOrdersItem findOneByOrderId(Long id) {
        String sql = "SELECT productId, name, count, price, status FROM product INNER JOIN ordersItem  " +
                "ON productId = product._id INNER JOIN orders ON" +
                "orderId = orders._id WHERE orderId = ?";
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            pStatement.setLong(1, id);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                DetailOrdersItem detailOrdersItem = new DetailOrdersItem();
                detailOrdersItem.setProductId(resultSet.getLong("productId"));
                detailOrdersItem.setName(resultSet.getString("name"));
                detailOrdersItem.setCount(resultSet.getInt("count"));
                detailOrdersItem.setPrice(resultSet.getBigDecimal("price"));
                detailOrdersItem.setStatus(resultSet.getString("status"));
                return detailOrdersItem;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
